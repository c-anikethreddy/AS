package com.cognizant.authorizationservice.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

//import org.junit.Rule;
import org.junit.jupiter.api.Test;
//import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.core.userdetails.UserDetails;

//import com.cognizant.authorizationservice.exception.UserNotFoundException;
import com.cognizant.authorizationservice.model.Pensioner;
import com.cognizant.authorizationservice.repository.UserRepository;
//import com.cognizant.authorizationservice.service.UserDetailService;

@SpringBootTest
public class UserDetailServiceTest {
	UserDetails userdetails;

	@InjectMocks
	UserDetailService userDetailService;

	@Mock
	UserRepository userservice;

	@Test
	public void loadUserByUsernameTest() {

		Pensioner user1 = new Pensioner(10, "pensioner", "pensioner", "pensioner@mail.com");
		Optional<Pensioner> data = Optional.of(user1);
		when(userservice.findByEmail("pensioner@mail.com")).thenReturn(user1);
		UserDetails loadUserByUsername2 = userDetailService.loadUserByUsername("pensioner@mail.com");
		assertEquals(user1.getEmail(), loadUserByUsername2.getUsername());

	}


}
