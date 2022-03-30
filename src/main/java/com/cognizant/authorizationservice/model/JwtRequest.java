package com.cognizant.authorizationservice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JwtRequest implements Serializable{

	//Email for Agent
	private String username="root@gmail.com";
	//Password
	private String password="root";
	
	
}
