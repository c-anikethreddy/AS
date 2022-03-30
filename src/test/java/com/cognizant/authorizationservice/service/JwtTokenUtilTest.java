package com.cognizant.authorizationservice.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.authorizationservice.exception.UserNotFoundException;
import com.cognizant.authorizationservice.repository.UserRepository;
import com.cognizant.authorizationservice.service.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@SpringBootTest
public class JwtTokenUtilTest {
	UserDetails userdetails;

	@InjectMocks
	JwtTokenUtil jwtUtil;

	@Mock
	UserRepository userservice;

	@Mock
	Claims claim;

	@Test
	public void generateTokenTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		assertNotNull(generateToken);
	}

	@Test
	public void validateTokenTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	@Test
	public void validateTokenWithNameTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	@Test
	public void validateTokenWithNameFalseTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		// UserDetails user1 = new User("admin1", "admin1", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	@Test
	public void extractUsernameTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		String token = jwtUtil.generateToken(userdetails);
		String username = jwtUtil.extractUsername(token);
		assertEquals(username, "admin");
	}

}
