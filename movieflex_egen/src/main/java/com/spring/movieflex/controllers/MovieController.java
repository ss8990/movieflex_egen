package com.spring.movieflex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieflex.entities.Movie;
import com.spring.movieflex.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getMovies(){
		return service.getMovies();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie getMovie(@PathVariable("id") String id){
		return service.getMovie(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> createMovies(@RequestBody List<Movie> movies){
		return service.createMovies(movies);
	}
	
	/*@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie createMovie(@RequestBody Movie movie){
		return service.createMovie(movie);
	}*/
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes="application/json")
	public Movie updateMovie(@PathVariable("id")String id,@RequestBody Movie movie){
		return service.update(id,movie);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteMovie(@PathVariable("id") String id){
		service.delete(id);
	}
	
	
}
