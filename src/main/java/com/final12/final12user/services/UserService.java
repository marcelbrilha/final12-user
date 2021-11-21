package com.final12.final12user.services;

import com.final12.final12user.entities.User;

public interface UserService {

	User findByEmail(String email) throws Exception;
	
	User findById(Long id) throws Exception;
}
