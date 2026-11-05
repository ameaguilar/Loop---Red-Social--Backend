package com.generation.ecommerce.models;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "existencias", nullable = false)
    private Integer existencias;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    public Producto(String nombre, String descripcion, String imagen, Double precio, Integer existencias) {
        this.nombre = nombre.toUpperCase();
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = (precio <0) ? 1 : precio;
        this.existencias = (existencias < 0) ? 1 : existencias;
    }//constructor

    public Producto(){}//contructor vacio
    public Integer getId() {
        return id;
    }// getId

    public String getNombre() {
        return nombre;
    }// getNombre

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }// setNombre

    public String getDescripcion() {
        return descripcion;
    }// getDescripcion

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;

    }// setDescripcion
    public String getImagen() {
        return imagen;
    }// getImagen

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }// setImagen

    public Double getPrecio() {
        return precio;
    }// getPrecio

    public void setPrecio(Double precio) {
        this.precio = (precio < 0) ? 1 : precio;
    }// setPrecio

    public Integer getExistencias() {
        return existencias;
    }// getExistencias

    public void setExistencias(Integer existencias) {
        this.existencias = (existencias < 0) ? 1 : existencias;
    }// setExistencias

    public Categoria getCategoria() {
        return categoria;
    }// getCategoria

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }// setCategoria

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                '}';
    }
}//Class Producto

