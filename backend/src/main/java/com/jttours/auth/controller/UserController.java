package com.jttours.auth.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jttours.auth.model.User;
import com.jttours.auth.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserService userService;

	// adding new user
	@PostMapping("/register")
	public ResponseEntity<?> addNewUser(@RequestBody User user) {
		User response = userService.addUser(user);
		if(response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST); 
		}
	}

	@GetMapping("/users")
	@PreAuthorize("hasAuthority('ADMIN') and hasAuthority('CUSTOMER')")
	public List<User> allUser() {
		return userService.getAllUser();
	}
}