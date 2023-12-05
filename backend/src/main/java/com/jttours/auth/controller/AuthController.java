package com.jttours.auth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jttours.auth.model.AuthRequest;
import com.jttours.auth.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String token = jwtService.generateToken(userDetails);

			Map<String, String> response = new HashMap<>();
			response.put("token", token);
			response.put("role", new ArrayList<>(userDetails.getAuthorities()).get(0).toString());
			response.put("username", userDetails.getUsername());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
