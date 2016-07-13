package com.spring.movieflex.repository;

import java.util.List;

import com.spring.movieflex.entities.Movie;

public interface MovieRepository {


	Movie createMovie(Movie movie);

	List<Movie> getMovies();

	Movie getMovie(String id);

	Movie update(Movie movie);

	void delete(Movie movie);

	List<Movie> createMovies(List<Movie> movies);

}
