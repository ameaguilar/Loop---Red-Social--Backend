package com.develoopers.loop.repositories;

import com.develoopers.loop.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<Users, Integer> {
}
