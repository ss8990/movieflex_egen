package com.spring.movieflex.controllers;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieflex.entities.User;
import com.spring.movieflex.service.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/user")
	public Principal authenticate(Principal user){
		return user;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> authenticate(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
		System.out.println(user);
		User existing=userservice.authenticate(user);
		if(existing.getEmail().equals(user.getEmail())&&existing.getPassword().equals(user.getPassword())){
			request.getSession().setAttribute("user", user);
			ResponseEntity<String> responseEntity=null;
			if(existing.getRole().equals(user.getRole())){
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
			}else{
				responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return responseEntity;
		}else{
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
	}
}
