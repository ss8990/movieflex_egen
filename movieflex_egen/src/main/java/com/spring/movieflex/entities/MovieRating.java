package com.spring.movieflex.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table(name="Movie_Rating")
public class MovieRating {
	
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="review")
	private String review;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
}
