package com.microservice.recommendation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recommendation")
public class RecommendationEntity {

	
	@Id
	private Long recommendationId;
	
	@Column(name = "destinationId")
	private Long destinationId;
	
	@Column(name = "author")
	private String author;

	@Column(name = "rate")
	private int rate;

	@Column(name = "content")
	private String content;


	public RecommendationEntity(Long recommendationId, Long destinationId, String author, int rate, String content) {
		super();
		this.recommendationId = recommendationId;
		this.destinationId = destinationId;
		this.author = author;
		this.rate = rate;
		this.content = content;
	}
	
	public RecommendationEntity() {
		super();
	}
	
	public Long getRecommendationId() {
		return recommendationId;
	}

	public void setRecommendationId(Long recommendationId) {
		this.recommendationId = recommendationId;
	}

	public Long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public String toString() {
		return "UserEntity [RecommendationId=" + recommendationId + ", destinationId=" + destinationId + ", author=" + author + ", rate=" + rate + ", content=" + content 
				+ "]";
	}

}