package com.cognizant.authorizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authorizationservice.model.Pensioner;

@Repository
public interface UserRepository extends JpaRepository<Pensioner, Integer> {

	Pensioner findByEmail(String email);

}
