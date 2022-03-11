package com.microservice.recommendation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.recommendation.exception.RecordNotFoundException;
import com.microservice.recommendation.model.RecommendationEntity;
import com.microservice.recommendation.repository.RecommendationRepository;


@Service
public class RecommendationService {

    @Autowired
    RecommendationRepository repository;
   
    private static final Logger LOG = LoggerFactory.getLogger(RecommendationService.class);
    
    public List<RecommendationEntity> getAllRecommendation()
    {
        List<RecommendationEntity> recommendationList = repository.findAll();
         
        if(recommendationList.size() > 0) {
            return recommendationList;
        } else {
            return new ArrayList<RecommendationEntity>();
        }
    }
    
    public RecommendationEntity createOrUpdate(RecommendationEntity entity) throws RecordNotFoundException
    {
       
            entity = repository.save(entity);
            LOG.debug("/Recommendation response: {}", entity);
            return entity;
        
    }
}