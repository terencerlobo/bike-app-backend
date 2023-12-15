package com.rental.bike.bikeapp.repository;

import org.springframework.stereotype.Repository;

import com.rental.bike.bikeapp.modal.User;

public interface UserRepository {
	
	User findByUserNameAndPassword(String userName, String password);

}
