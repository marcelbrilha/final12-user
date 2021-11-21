package com.final12.final12user.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.final12.final12user.entities.User;
import com.final12.final12user.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) throws Exception {
		log.info("Iniciando pesquisa do usuário, id: " + id);
		return ResponseEntity.ok(this.userService.findById(id));
	}
	
	@GetMapping(value = "/v1/users")
	public ResponseEntity<User> findByEmail(@RequestParam String email) throws Exception {
		log.info("Iniciando pesquisa do usuário, e-mail: " + email);
		return ResponseEntity.ok(this.userService.findByEmail(email));
	}
}
