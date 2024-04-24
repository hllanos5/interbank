package com.interbank.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interbank.apirest.model.User;
import com.interbank.apirest.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("{id}")
	public User searchUserById(@PathVariable("id") Long id ) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("{id}")
	public void deleteUserById(@PathVariable("id") Long id ) {
		userService.deleteUser(id);
	}

}
