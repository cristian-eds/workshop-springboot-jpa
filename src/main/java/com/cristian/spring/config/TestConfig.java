package com.cristian.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cristian.spring.entities.Category;
import com.cristian.spring.entities.Order;
import com.cristian.spring.entities.User;
import com.cristian.spring.entities.enums.OrderStatus;
import com.cristian.spring.repositories.CategoryRepository;
import com.cristian.spring.repositories.OrderRepository;
import com.cristian.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Computers");
		Category cat3 = new Category(null, "Books");

		User u1 = new User(null, "Fulano Junior", "fulano@email.com", "9090909090", "12345");
		User u2 = new User(null, "Ciclano Grenn", "ciclano@email.com", "99999999", "54321");

		Order o1 = new Order(null, Instant.parse("2023-03-20T20:59:10Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-03-22T10:59:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-03-10T14:40:10Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		

	}

}
