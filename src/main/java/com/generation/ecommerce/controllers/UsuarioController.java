package com.generation.ecommerce.controllers;

import com.generation.ecommerce.models.Usuario;
import com.generation.ecommerce.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private static final Pattern USERNAME = Pattern.compile("[A-Za-z0-9_]{4,20}");
    private static final Pattern PHONE = Pattern.compile("[0-9]{10}");
    private static final Pattern PASSWORD = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*._-])[A-Za-z\\d!@#$%^&*._-]{8,20}$");

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping
    public Map<String, String> register(@RequestBody Usuario user) {
        if (blank(user.getNombre()) || user.getNombre().length() > 100 || blank(user.getApellido()) || user.getApellido().length() > 100
                || user.getEmail() == null || user.getEmail().length() > 254 || !user.getEmail().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")
                || user.getUsername() == null || !USERNAME.matcher(user.getUsername()).matches()
                || user.getTelefono() == null || !PHONE.matcher(user.getTelefono()).matches()
                || user.getPassword() == null || !PASSWORD.matcher(user.getPassword()).matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Revisa los datos del formulario.");
        }
        user.setEmail(user.getEmail().trim().toLowerCase());
        user.setUsername(user.getUsername().trim());
        if (repository.existsByEmailIgnoreCase(user.getEmail()) || repository.existsByUsernameIgnoreCase(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El correo o username ya está registrado.");
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return Map.of("message", "Cuenta creada");
    }

    @GetMapping("/me")
    public Usuario me(Authentication auth) {
        return repository.findByIdentifier(auth.getName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private boolean blank(String value) {
        return value == null || value.isBlank();
    }
}
