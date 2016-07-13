package com.spring.movieflex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieflex.entities.Movie;
import com.spring.movieflex.entities.MovieRating;
import com.spring.movieflex.service.MovieService;

@RestController
@RequestMapping("/movies")
public class RatingController {

	@Autowired
	private MovieService service;
	
/*	@RequestMapping(value="/{id}/reviews",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie addRating(@PathVariable("id") String id){
		Movie movie = service.getMovie(id);
		movie.getRatings();
		MovieRating movierating=new MovieRating();
		movierating.setRating(rating);
		movie.getRatings().add(movierating);
		service.update(id, movie);
		return movie;
	}*/
	
	@RequestMapping(value="/{id}/reviews",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public Movie addReview(@PathVariable("id") String id, @RequestBody MovieRating choice){
		Movie movie = service.getMovie(id);
		MovieRating movierating=new MovieRating();
		if(choice.getRating()==null){
			choice.setRating(0);
		}else{
			movierating.setRating(choice.getRating());
		}
		if(choice.getReview()==null){
			choice.setReview("");
		}else{
		movierating.setReview(choice.getReview());
		}
		movie.getRatings().add(movierating);
		service.update(id, movie);
		return movie;
	}
}
