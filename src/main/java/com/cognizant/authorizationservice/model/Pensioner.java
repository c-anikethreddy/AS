package com.cognizant.authorizationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Pensioner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pensionerId;
	private String name;
	private String password;
	private String email;

	
	
}
