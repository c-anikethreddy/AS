package com.cognizant.authorizationservice.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.authorizationservice.model.JwtRequest;

@SpringBootTest
public class JwtRequestTest {
	JwtRequest jwtRequest = new JwtRequest();

	@Test
	public void testAllConstructor() {
		JwtRequest jwtRequest = new JwtRequest("pensioner", "pensioner");
		assertEquals(jwtRequest.getUsername(), "pensioner");
	}

	@Test
	public void testUsername() {
		jwtRequest.setUsername("pensioner");
		assertEquals(jwtRequest.getUsername(), "pensioner");
	}

	@Test
	public void testPassword() {
		jwtRequest.setPassword("pensioner");
		assertEquals(jwtRequest.getPassword(), "pensioner");
	}

}
