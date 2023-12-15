package com.rental.bike.bikeapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rental.bike.bikeapp.modal.User;
import com.rental.bike.bikeapp.service.UserService;

@RestController
@RequestMapping("/bike")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@GetMapping("/testAPI")
	public String testAPI(String id) {
		
		LOGGER.info("This is the Id!! {}",id);
		return "SUCCESS";
	}
	
	@GetMapping("/authenticate")
	public ResponseEntity<User> authenticateUser(@RequestParam String userName, 
			@RequestParam String password){
		User user = userService.authenticateUser(userName, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
	}

}
