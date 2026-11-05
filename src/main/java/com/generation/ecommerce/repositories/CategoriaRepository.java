package com.generation.ecommerce.repositories;

import com.generation.ecommerce.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

    Optional<Categoria> findByNombre(String nombre);


}
