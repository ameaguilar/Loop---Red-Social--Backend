package com.develoopers.loop.repositories;

import com.develoopers.loop.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
