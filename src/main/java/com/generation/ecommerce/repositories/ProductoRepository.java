package com.generation.ecommerce.repositories;

import com.generation.ecommerce.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}// interface ProductoRepository