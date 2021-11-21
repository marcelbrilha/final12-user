package com.final12.final12user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.final12.final12user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
