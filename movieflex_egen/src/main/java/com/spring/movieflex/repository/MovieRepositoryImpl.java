package com.spring.movieflex.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.movieflex.entities.Movie;

@Repository
@EnableTransactionManagement
public class MovieRepositoryImpl implements MovieRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Movie createMovie(Movie movie) {
		
		em.persist(movie);
		
		
		return movie;
	}
	
	@Override
	public List<Movie> createMovies(List<Movie> movies) {
		
		for(int i=0;i<movies.size();i++){
		em.persist(movies.get(i));
		}
		
		return movies;
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> queries=em.createQuery("from Movie",Movie.class);
		return queries.getResultList();
	}

	@Override
	public Movie getMovie(String id) {
		// TODO Auto-generated method stub
		return em.find(Movie.class, id);
	}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		// TODO Auto-generated method stub
		em.remove(movie);
	}

}
