package com.cognizant.authorizationservice.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

//import com.cognizant.authorizationservice.model.AuthResponse;

@SpringBootTest

@RestController
public class AuthResponseTest {
	AuthResponse authResponse = new AuthResponse(true);

	@Test
	public void testIsValid() {
		authResponse.setValid(true);
		assertEquals(authResponse.isValid(), true);
	}

	@Test
	public void testtoString() {
		String s = authResponse.toString();
		assertEquals(authResponse.toString(), s);
	}

}
