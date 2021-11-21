package com.final12.final12user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final12.final12user.entities.User;
import com.final12.final12user.exceptions.ObjectNotFoundException;
import com.final12.final12user.repositories.UserRepository;
import com.final12.final12user.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) throws Exception {
		return userRepository
				.findByEmail(email)
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}

	@Override
	public User findById(Long id) throws Exception {
		return userRepository
				.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
}
