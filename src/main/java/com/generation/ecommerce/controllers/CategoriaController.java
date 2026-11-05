package com.generation.ecommerce.controllers;

import com.generation.ecommerce.models.Categoria;
import com.generation.ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ecommerce/categorias/")
public class CategoriaController {

    private final CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }// constructor

    @GetMapping
    public List<Categoria> getCategorias(){
        return service.getCategorias();
    }// getCategorias

    @GetMapping("{id}")
    public Categoria getCategoria(@PathVariable Integer id){
        return service.getCategorias().get(id);
    }

    @DeleteMapping("{id}")
    public Categoria deleteCategoria(@PathVariable Integer id){
        return service.deleteCategorias(id);
    }

    @PostMapping
    public Categoria addCategoria(@RequestBody Categoria categoria){

        return service.addCategoria(categoria);
    }// addCategoria

    @PutMapping
    public Categoria updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){
        return service.updateCategoria(id, categoria);
    }
}// class CategoriaController
