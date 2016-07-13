package com.spring.movieflex.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.spring.movieflex.entities.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User create(User user) {
		user.setRole("USER");
		em.persist(user);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query=em.createNamedQuery("User.findByEmail",User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	
	
}
