package com.cognizant.authorizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authorizationservice.exception.UserNotFoundException;
import com.cognizant.authorizationservice.model.AuthResponse;
import com.cognizant.authorizationservice.model.JwtRequest;
import com.cognizant.authorizationservice.service.JwtTokenUtil;
import com.cognizant.authorizationservice.service.UserDetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailService userDetailService;

	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("Health is up, 200OK", HttpStatus.OK);
	}

	// Login to generate Token
	@PostMapping("/getToken")
	public String getToken(@RequestBody JwtRequest jwtRequest) {
        log.info("11111");
        
		final UserDetails userDetails = userDetailService.loadUserByUsername(jwtRequest.getUsername());
		//System.out.println(jwtRequest.getPassword());
		if (!jwtRequest.getPassword().equals(userDetails.getPassword())) {
			throw new UserNotFoundException("Wrong Credentials");
		}
		log.info("3333333");
		return jwtTokenUtil.generateToken(userDetails);

	}

	// Request Validation
	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token) {
		AuthResponse authResponse = new AuthResponse();
		System.out.println(jwtTokenUtil.validateToken(token.substring(7)));
		authResponse.setValid(jwtTokenUtil.validateToken(token.substring(7)));
		return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}

}
