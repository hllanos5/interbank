package com.interbank.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interbank.apirest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	Optional<User> findOneByEmail(String email);
}
