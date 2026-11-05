package com.generation.ecommerce.controllers;

import com.generation.ecommerce.models.Publicacion;
import com.generation.ecommerce.repositories.PublicacionRepository;
import com.generation.ecommerce.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    private final PublicacionRepository posts;
    private final UsuarioRepository users;

    public PublicacionController(PublicacionRepository posts, UsuarioRepository users) {
        this.posts = posts;
        this.users = users;
    }

    public record PostRequest(String contenido, String etiqueta) {
    }

    public record PostResponse(Long id, String autor, String username, String contenido, String etiqueta,
                               Instant createdAt) {
    }

    @GetMapping
    public List<PostResponse> list() {
        return posts.findAllByOrderByCreatedAtDesc().stream().map(this::toDto).toList();
    }

    @PostMapping
    public PostResponse create(@RequestBody PostRequest request, Authentication auth) {
        if (request.contenido() == null || request.contenido().isBlank() || request.contenido().length() > 1000 || request.etiqueta() != null && request.etiqueta().length() > 50)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contenido o etiqueta no válidos.");
        var user = users.findByIdentifier(auth.getName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        var post = new Publicacion();
        post.setUsuario(user);
        post.setContenido(request.contenido().trim());
        post.setEtiqueta(request.etiqueta() == null || request.etiqueta().isBlank() ? null : request.etiqueta().trim());
        return toDto(posts.save(post));
    }

    private PostResponse toDto(Publicacion post) {
        var user = post.getUsuario();
        return new PostResponse(post.getId(), user.getNombre() + " " + user.getApellido(), user.getUsername(), post.getContenido(), post.getEtiqueta(), post.getCreatedAt());
    }
}

