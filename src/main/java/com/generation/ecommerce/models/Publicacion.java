package com.generation.ecommerce.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 1000)
    private String contenido;
    @Column(length = 50)
    private String etiqueta;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String v) {
        contenido = v;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String v) {
        etiqueta = v;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario v) {
        usuario = v;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
