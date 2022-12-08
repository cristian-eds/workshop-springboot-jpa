package com.cristian.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cristian.spring.entities.User;
import com.cristian.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Fulano Junior","fulano@email.com","9090909090","12345");
		User u2 = new User(null,"Ciclano Grenn","ciclano@email.com","99999999","54321");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
}

