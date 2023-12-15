package com.rental.bike.bikeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.bike.bikeapp.modal.User;
import com.rental.bike.bikeapp.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public User authenticateUser(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

}
