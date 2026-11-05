package com.generation.ecommerce.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {
    private final byte[] key;
    private final long expirationMinutes;
    public JwtService(@Value("${app.jwt-secret}") String secret,
                      @Value("${app.jwt-expiration-minutes:180}") long expirationMinutes) {
        this.key = secret.getBytes(StandardCharsets.UTF_8);
        if (key.length < 32) throw new IllegalStateException("APP_JWT_SECRET debe tener al menos 32 bytes.");
        this.expirationMinutes = expirationMinutes;
    }
    public String generarToken(String subject) {
        Instant now = Instant.now();
        return Jwts.builder().subject(subject).issuedAt(Date.from(now))
            .expiration(Date.from(now.plusSeconds(expirationMinutes * 60)))
            .signWith(Keys.hmacShaKeyFor(key)).compact();
    }
    public String validarYLeerSubject(String token) {
        try { return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(key)).build()
                .parseSignedClaims(token).getPayload().getSubject(); }
        catch (io.jsonwebtoken.JwtException | IllegalArgumentException ex) { return null; }
    }
}
