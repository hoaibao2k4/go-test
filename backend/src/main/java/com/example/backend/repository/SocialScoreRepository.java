package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.SocialScore;

@Repository
public interface SocialScoreRepository extends JpaRepository<SocialScore, String> {
    
}
