package com.spring.movieflex.service;

import java.util.List;

import com.spring.movieflex.entities.Movie;

public interface MovieService {


	Movie createMovie(Movie movie);

	List<Movie> getMovies();

	Movie getMovie(String id);

	Movie update(String id,Movie movie);

	void delete(String id);

	List<Movie> createMovies(List<Movie> movies);

	
}
