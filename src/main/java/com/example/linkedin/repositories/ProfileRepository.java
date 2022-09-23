package com.example.linkedin.repositories;

import com.example.linkedin.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findProfileByEmailAndPassword(String email, String password);
}
