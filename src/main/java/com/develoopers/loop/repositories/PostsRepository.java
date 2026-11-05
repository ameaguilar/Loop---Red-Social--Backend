package com.develoopers.loop.repositories;

import com.develoopers.loop.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository  extends JpaRepository<Posts, Integer> {
}
