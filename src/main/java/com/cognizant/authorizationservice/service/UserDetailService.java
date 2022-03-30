package com.cognizant.authorizationservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authorizationservice.exception.UserNotFoundException;
import com.cognizant.authorizationservice.model.Pensioner;
import com.cognizant.authorizationservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository pensionerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//pensionerRepository.save(new Pensioner(1, "p1", "root","root@gmail.com"));
		Pensioner pensioner = pensionerRepository.findByEmail(email);
		log.info("222222");
		if (pensioner == null) {
			throw new UserNotFoundException("Wrong Email/Password.");
		}
		return new User(pensioner.getEmail(), pensioner.getPassword(), new ArrayList());
	}
}
