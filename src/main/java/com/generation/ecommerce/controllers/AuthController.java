package com.generation.ecommerce.controllers;

import com.generation.ecommerce.dtos.LoginRequest;
import com.generation.ecommerce.repositories.UsuarioRepository;
import com.generation.ecommerce.services.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UsuarioRepository usuarios;
    private final PasswordEncoder encoder;
    private final JwtService jwt;
    @Value("${app.cookie-secure:false}")
    private boolean secureCookie;

    public AuthController(UsuarioRepository usuarios, PasswordEncoder encoder, JwtService jwt) {
        this.usuarios = usuarios;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @GetMapping("/csrf")
    public Map<String, String> csrf(CsrfToken token) {
        return Map.of("token", token.getToken());
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        if (request.getIdentifier() == null || request.getPassword() == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        var user = usuarios.findByIdentifier(request.getIdentifier().trim()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        if (!encoder.matches(request.getPassword(), user.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        ResponseCookie cookie = ResponseCookie.from("LOOP_SESSION", jwt.generarToken(user.getUsername()))
                .httpOnly(true).secure(secureCookie).sameSite("Lax").path("/").maxAge(Duration.ofHours(3)).build();
        response.addHeader("Set-Cookie", cookie.toString());
        return Map.of("message", "Sesión iniciada");
    }

    @PostMapping("/logout")
    public Map<String, String> logout(HttpServletResponse response) {
        response.addHeader("Set-Cookie", ResponseCookie.from("LOOP_SESSION", "").httpOnly(true).secure(secureCookie)
                .sameSite("Lax").path("/").maxAge(Duration.ZERO).build().toString());
        return Map.of("message", "Sesión cerrada");
    }
}
