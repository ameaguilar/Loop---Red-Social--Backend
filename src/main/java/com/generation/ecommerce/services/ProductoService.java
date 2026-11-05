package com.generation.ecommerce.services;

import com.generation.ecommerce.models.Categoria;
import com.generation.ecommerce.models.Producto;
import com.generation.ecommerce.repositories.CategoriaRepository;
import com.generation.ecommerce.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository repository, CategoriaRepository categoriaRepository){
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }// constructor

    public List<Producto> getProductos() {
        return repository.findAll(); // SELECT * FROM Producto;
    }// getProductos

    public Producto getProducto(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El producto con el id [" + id + "] no existe."));
    }// getProducto

    public Producto deleteProducto(Integer id) {
        Producto producto = null;

        if( repository.existsById(id) ){ // 1. Buscar el producto por id
            producto = repository.findById(id).get();
            repository.delete(producto);
        }// if

        return producto;
    }// deleteProducto


    public Producto addProducto(Producto producto) {

        if(!producto.getNombre().isBlank() && !producto.getDescripcion().isBlank() &&
                producto.getNombre() != null && producto.getDescripcion() != null &&
                producto.getCategoria() != null && producto.getCategoria().getId() != null){
            Integer categoriaId = producto.getCategoria().getId();
            Categoria categoria = categoriaRepository.findById(categoriaId).get();
            producto.setCategoria(categoria);
            repository.save(producto);
        }// if

        return producto;
    }// addProducto

        public Producto updateProducto(Integer id, Producto producto){
            Producto prod = repository.findById(id).get();

            if( repository.existsById(id) ){
                Producto p = repository.findById(id).get();

                if(producto.getNombre() != null && !producto.getNombre().isBlank()) p.setNombre(producto.getNombre());
                if(producto.getDescripcion() != null && !producto.getDescripcion().isBlank()) p.setDescripcion(producto.getDescripcion());
                if(producto.getImagen() != null && !producto.getImagen().isBlank()) p.setImagen(producto.getImagen());
                if(producto.getPrecio() != null) p.setPrecio(producto.getPrecio());
                if(producto.getExistencias() != null) p.setExistencias(producto.getExistencias());
                if(producto.getCategoria() != null && producto.getCategoria().getId() != null){
                    if(categoriaRepository.existsById(producto.getCategoria().getId())){
                        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getId()).get();
                        p.setCategoria(categoria);
                    }// if categoria exists
                }// if categoria not null

                prod = p;
                repository.save(prod);

            }// if

            return producto;
        }// updateProducto
    }// class ProductoService