package com.generation.ecommerce.repositories;

import com.generation.ecommerce.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByUsernameIgnoreCase(String username);

    @Query("select u from Usuario u where lower(u.email) = lower(:identifier) or lower(u.username) = lower(:identifier)")
    Optional<Usuario> findByIdentifier(@Param("identifier") String identifier);

    boolean existsByEmailIgnoreCase(String email);
    boolean existsByUsernameIgnoreCase(String username);

}// interface UsuarioRepository
