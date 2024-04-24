package com.interbank.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interbank.apirest.dto.FeignDTO;
import com.interbank.apirest.feign.client.FeignClientApp;
import com.interbank.apirest.model.User;
import com.interbank.apirest.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FeignClientApp userFeignClientApp;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUserById(Long id) {
		 Optional<User> optionalUser = userRepository.findById(id);
		 return optionalUser.get();
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
