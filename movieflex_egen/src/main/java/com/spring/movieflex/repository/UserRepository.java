package com.spring.movieflex.repository;

import com.spring.movieflex.entities.User;

public interface UserRepository {

	User create(User user);
	User findByEmail(String email);
}
