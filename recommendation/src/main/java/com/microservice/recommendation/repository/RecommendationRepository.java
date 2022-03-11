package com.microservice.recommendation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.recommendation.model.RecommendationEntity;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationEntity, Long>{

}