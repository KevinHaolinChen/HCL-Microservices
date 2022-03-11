package com.microservice.recommendation.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.recommendation.exception.RecordNotFoundException;
import com.microservice.recommendation.model.RecommendationEntity;
import com.microservice.recommendation.service.RecommendationService;


@RestController
public class RecommendationController {
	
	
 private static final Logger LOG = LoggerFactory.getLogger(RecommendationController.class);
	
	@Autowired
	RecommendationService recommendationService;
	
	
	@RequestMapping(value = "/recommendation/all", method=RequestMethod.GET  , produces={"application/json"})
    public ResponseEntity<List<RecommendationEntity>> getAllRecommendation() {
        List<RecommendationEntity> list = recommendationService.getAllRecommendation();
 
        return new ResponseEntity<List<RecommendationEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	   @RequestMapping(value = "/recommendation/create", method=RequestMethod.POST , consumes={"application/json"} , produces={"application/json"})
	    public ResponseEntity<RecommendationEntity> createOrUpdateUser(@RequestBody RecommendationEntity recommendation)
	                                                    throws RecordNotFoundException {
		 
		 LOG.debug("/Recommendation for controller: {}", recommendation);
		 RecommendationEntity updated = recommendationService.createOrUpdate(recommendation);
	        return new ResponseEntity<RecommendationEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 	   
}
	 

