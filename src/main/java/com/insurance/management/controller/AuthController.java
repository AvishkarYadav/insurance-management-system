package com.insurance.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.management.dto.RegisterRequest;
import com.insurance.management.model.User;
import com.insurance.management.repository.UserRepository;
import com.insurance.management.serviceimpl.CustomUserDetailsService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;




	

	@PostMapping("/register")
	public String registerUser(@RequestBody RegisterRequest request) {
		if (userRepository.existsByUsername(request.getUsername())) {
			return "Username already exists";
		}
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		if (request.getRole() != null) {
			user.setRole(request.getRole());
		} else {
			user.setRole("ROLE_USER");
		}
		userRepository.save(user);
		return "User registered successfully";
	}

	
		
	}


