package com.generation.ecommerce.repositories;
import com.generation.ecommerce.models.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PublicacionRepository extends JpaRepository<Publicacion,Long> {
    List<Publicacion> findAllByOrderByCreatedAtDesc();
}
