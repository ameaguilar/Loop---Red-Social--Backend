package com.generation.ecommerce.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private Integer id;
    @Column (name = "nombre",nullable = false, unique = true)
    private String nombre;
    @Column(name = "descripcion",nullable = false, length = 200)
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }// constructor

    public Categoria() { }// constructor vacío
    public Integer getId() {
        return id;
    }// getId

    public String getNombre() {
        return nombre;
    }// getNombre

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }// setNombre

    public String getDescripcion() {
        return descripcion;
    }// getDescripcion

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }// setDescripcion

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}// class Categoria
