package com.develoopers.loop.repositories;

import com.develoopers.loop.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
