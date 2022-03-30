package com.cognizant.authorizationservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.authorizationservice.model.AuthResponse;
import com.cognizant.authorizationservice.model.JwtRequest;
import com.cognizant.authorizationservice.model.Pensioner;
import com.cognizant.authorizationservice.service.JwtTokenUtil;
import com.cognizant.authorizationservice.service.UserDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class AuthControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	JwtTokenUtil jwtTokenUtil;

	@MockBean
	UserDetailService userDetailService;

	@Test
	public void getHealthTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/health")).andReturn();
		String healthExpected = "Health is up, 200OK";
		assertEquals(healthExpected, result.getResponse().getContentAsString());
	}

	@Test
	void getTokenTest() throws Exception {

		Pensioner pensioner = new Pensioner(10, "pensioner", "pensioner", "pensioner@mail.com");
		UserDetails loadUserByUsername = userDetailService.loadUserByUsername("pensioner@mail.com");
		UserDetails value = new User(pensioner.getEmail(), pensioner.getPassword(), new ArrayList<>());
		JwtRequest jwtRequest = new JwtRequest("pensioner@mail.com", "pensioner");
		when(userDetailService.loadUserByUsername("pensioner@mail.com")).thenReturn(value);
		when(jwtTokenUtil.generateToken(loadUserByUsername)).thenReturn("token");

		mockMvc.perform(MockMvcRequestBuilders.post("/getToken").content(asJsonString(jwtRequest))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}


	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
