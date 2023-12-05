package com.jttours.auth.config;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.jttours.auth.model.User;
import com.jttours.auth.repository.UserRepository;

@Component
public class UserUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws ResponseStatusException {
		Optional<User> userInfo = repository.findById(username);
		try {
			if (userInfo.isPresent())
				return userInfo.map(UserUserDetails::new).get();
			else
				throw new Exception();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, username + " does not exists");
		}
	}
}
