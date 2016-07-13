package com.spring.movieflex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.movieflex.entities.Movie;
import com.spring.movieflex.exceptions.MovieNotFoundException;
import com.spring.movieflex.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository repo;
	
	@Override
	public Movie createMovie(Movie movie) {
		return repo.createMovie(movie);
	}
	
	@Override
	public List<Movie> createMovies(List<Movie> movies) {
		return repo.createMovies(movies);
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return repo.getMovies();
	}

	@Override
	public Movie getMovie(String id) {
		Movie movie=repo.getMovie(id);
		if(movie==null){
			throw new MovieNotFoundException("Movie not found");
		}
		return repo.getMovie(id);
	}

	@Override
	public Movie update(String id,Movie movie) {
		Movie existing=repo.getMovie(id);
		if(existing==null){
			throw new MovieNotFoundException("Movie not found");
		}
		return repo.update(movie);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Movie movie=repo.getMovie(id);
		if(movie==null){
			throw new MovieNotFoundException("Movie not found");
		}
		repo.delete(movie);
	}

}
