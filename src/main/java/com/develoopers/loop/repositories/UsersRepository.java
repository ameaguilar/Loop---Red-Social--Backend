package com.develoopers.loop.repositories;

import com.develoopers.loop.models.Users;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository  extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
