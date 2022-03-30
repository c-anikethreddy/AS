package com.cognizant.authorizationservice.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private String username;
	private String jwtToken;

	public JwtResponse(String username, String jwtToken) {
		this.username = username;
		this.jwtToken = jwtToken;
	}

	public String getToken() {
		return this.jwtToken;
	}

	public String getUsername() {
		return this.username;
	}

}
