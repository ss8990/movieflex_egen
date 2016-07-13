package com.spring.movieflex.service;

import com.spring.movieflex.entities.User;

public interface UserService {

	User create(User user);

	User authenticate(User user);
}
