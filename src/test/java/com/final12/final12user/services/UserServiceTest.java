package com.final12.final12user.services;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.final12.final12user.entities.User;
import com.final12.final12user.exceptions.ObjectNotFoundException;
import com.final12.final12user.repositories.UserRepository;
import com.final12.final12user.services.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@TestConfiguration
	static class UserServiceTestConfiguration {
		
		@Bean
		public UserService osService() {
			return new UserServiceImpl();
		}
		
	}
	
	@Test
	public void findByEmail() throws Exception {
		String email = "marcelbrilha@yahoo.com.br"; 
		User user = new User();
		user.setEmail(email);
		
		Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
		
		User response = userService.findByEmail(email);
		Assert.assertEquals(response.getEmail(), email);
	}
	
	@Test
	public void findByEmailThrowObjectNotFoundException() throws Exception {
		String email = "marcelbrilha@yahoo.com.br"; 
		Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.ofNullable(null));
		exception.expect(ObjectNotFoundException.class);
		exception.expectMessage("Usuário não encontrado");
		userService.findByEmail(email);
	}
	
	@Test
	public void findById() throws Exception {
		String email = "marcelbrilha@yahoo.com.br";
		Long id = 1L; 
		User user = new User();
		user.setEmail(email);
		
		Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));
		
		User response = userService.findById(id);
		Assert.assertEquals(response.getEmail(), email);
	}
	
	@Test
	public void findByIdThrowObjectNotFoundException() throws Exception {
		Long id = 1L; 
		Mockito.when(userRepository.findById(id)).thenReturn(Optional.ofNullable(null));
		exception.expect(ObjectNotFoundException.class);
		exception.expectMessage("Usuário não encontrado");
		userService.findById(id);
	}
}
