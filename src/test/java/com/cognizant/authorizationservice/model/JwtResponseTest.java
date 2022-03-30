package com.cognizant.authorizationservice.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cognizant.authorizationservice.model.JwtRequest;

@SpringBootTest
public class JwtResponseTest {
	

	@Test
	public void testAllConstructor() {
		JwtResponse jwtResponse = new JwtResponse("pensioner@mail.com","abc");
		assertEquals(jwtResponse.getUsername(), "pensioner@mail.com");
		assertEquals(jwtResponse.getToken(), "abc");
	}

	@Test
	public void testGetToken() {
		JwtResponse jwtResponse = new JwtResponse("pensioner@mail.com","abc");
		assertEquals(jwtResponse.getToken(), "abc");
	}

	@Test
	public void testPassword() {
		JwtResponse jwtResponse = new JwtResponse("pensioner@mail.com","abc");
		assertEquals(jwtResponse.getUsername(), "pensioner@mail.com");
	}

}
