package com.develoopers.loop.repositories;

import com.develoopers.loop.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
