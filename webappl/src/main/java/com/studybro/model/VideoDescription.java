package com.studybro.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class VideoDescription 
{
	@GraphId
	private Long id;
	
	private String price_status;
	
	private String headline;
	
	private Integer review_counts;
	
	private Integer ratings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrice_status() {
		return price_status;
	}

	public void setPrice_status(String price_status) {
		this.price_status = price_status;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public Integer getReview_counts() {
		return review_counts;
	}

	public void setReview_counts(Integer review_counts) {
		this.review_counts = review_counts;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public VideoDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoDescription(String price_status, String headline,
			Integer review_counts, Integer ratings) {
		super();
		this.price_status = price_status;
		this.headline = headline;
		this.review_counts = review_counts;
		this.ratings = ratings;
	}
	
	

}
