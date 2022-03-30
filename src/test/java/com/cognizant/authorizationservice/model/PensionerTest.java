package com.cognizant.authorizationservice.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

//import com.cognizant.authorizationservice.model.Pensioner;

@SpringBootTest
public class PensionerTest {
	Pensioner pensioner = new Pensioner();

	@Test
	public void testAgentlAllConstructor() {
		Pensioner p = new Pensioner(10, "pensioner", "pensioner", "pensioner@mail.com");

		assertEquals(p.getPensionerId(), 10);
		assertEquals(p.getName(), "pensioner");
		assertEquals(p.getPassword(), "pensioner");
		assertEquals(p.getEmail(), "pensioner@mail.com");
	}

	@Test
	public void testUserid() {
		pensioner.setPensionerId(10);
		;
		assertEquals(pensioner.getPensionerId(), 10);
	}

	@Test
	public void testUserPassword() {
		pensioner.setPassword("pensioner");
		assertEquals(pensioner.getPassword(), "pensioner");
	}

	@Test
	public void testUserName() {
		pensioner.setName("pensioner");
		assertEquals(pensioner.getName(), "pensioner");
	}

	@Test
	public void testEmail() {
		pensioner.setEmail("pensioner@mail.com");
		assertEquals(pensioner.getEmail(), "pensioner@mail.com");
	}

	@Test
	public void testToString() {
		String string = pensioner.toString();
		assertEquals(pensioner.toString(), string);
	}
	
}
