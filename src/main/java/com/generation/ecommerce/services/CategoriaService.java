package com.generation.ecommerce.services;

import com.generation.ecommerce.models.Categoria;
import com.generation.ecommerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }// constructor

    public List<Categoria> getCategorias() {
        return repository.findAll();
    }// getCategorias

    public Categoria getCategoria(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("La categoría con el id [" + id + "] no existe"));
    }// getCategoria

    public Categoria deleteCategorias(Integer id) {
        Categoria categoria = null;
        if (repository.existsById(id)) {
            categoria = repository.findById(id).get();
            repository.delete(categoria);
        }// if exists by id

        return categoria;
    }// deleteCategoria

    public Categoria addCategoria(Categoria categoria) {
        Optional<Categoria> cat = repository.findByNombre(categoria.getNombre());

        if (cat.isEmpty()) {
            repository.save(categoria);
        }
        return categoria;
    }// addCategoria

    public Categoria updateCategoria(Integer id, Categoria categoria) {
        Categoria cat = null;

        if(repository.existsById(id)){
            Categoria c = repository.findById(id).get();

            if(categoria.getNombre() != null && !categoria.getNombre().isEmpty()) c.setNombre(categoria.getNombre());
            if(categoria.getDescripcion() != null && !categoria.getDescripcion().isEmpty()) c.setDescripcion(categoria.getDescripcion());

            cat = c;
            repository.save(cat);
        }// if


        return cat;
    }// updateCategoria
}
