package com.jttours.auth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jttours.auth.model.User;
import com.jttours.auth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// adding user to database -> encoding with password
	public User addUser(User user) {
		// if user with same email id sign up, handler will throw error
		if(userRepo.findById(user.getUserName()).isPresent()) {
			return null;
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	// getting all user (access by only Admin)
	public List<User> getAllUser() {
		return (List<User>) userRepo.findAll();
	}

}
