package com.spring.movieflex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.movieflex.entities.User;
import com.spring.movieflex.exceptions.UserAlreadyExistsException;
import com.spring.movieflex.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public User create(User user) {
		User existing = repo.findByEmail(user.getEmail());
		if(existing!=null){
			throw new UserAlreadyExistsException("user already exists");
		}
		return repo.create(user);
	}

	@Override
	public User authenticate(User user) {
		User existing = repo.findByEmail(user.getEmail());
		if(existing!=null){
				
				return existing;
		}else{
			return null;
		}
		
	}

}
