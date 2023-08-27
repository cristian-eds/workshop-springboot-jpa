package com.cristian.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cristian.spring.entities.Category;
import com.cristian.spring.entities.Order;
import com.cristian.spring.entities.OrderItem;
import com.cristian.spring.entities.Payment;
import com.cristian.spring.entities.Product;
import com.cristian.spring.entities.User;
import com.cristian.spring.entities.enums.OrderStatus;
import com.cristian.spring.repositories.CategoryRepository;
import com.cristian.spring.repositories.OrderItemRepository;
import com.cristian.spring.repositories.OrderRepository;
import com.cristian.spring.repositories.ProductRepository;
import com.cristian.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Computers");
		Category cat3 = new Category(null, "Books");
		
		Product p1 = new Product(null, "Smart TV", "Smart Tv description", 1200D, "smarttv.com.br");
		Product p2 = new Product(null, "Smartphone", "Smartphone description", 1000D, "smartphonr.com.br");
		Product p3 = new Product(null, "PC Gamer", "PC Gamer description", 4200D, " ");
		Product p4 = new Product(null, "The Lord of the Rings", "Description book", 200D, " ");

		User u1 = new User(null, "Fulano Junior", "fulano@email.com", "9090909090", "12345");
		User u2 = new User(null, "Ciclano Grenn", "ciclano@email.com", "99999999", "54321");

		Order o1 = new Order(null, Instant.parse("2023-03-20T20:59:10Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-03-22T10:59:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-03-10T14:40:10Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		p1.getCategories().add(cat1);
		
		p2.getCategories().add(cat1);
		
		p3.getCategories().add(cat1);
		p3.getCategories().add(cat2);
		
		p4.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1,p1, 2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3, 1,p3.getPrice());
		OrderItem oi3 = new OrderItem(o2,p1, 2,p1.getPrice());
		OrderItem oi4 = new OrderItem(o3,p4, 2,p4.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment payment1 = new Payment(null, Instant.parse("2023-03-20T22:59:10Z"),o1);
		
		o1.setPayment(payment1);
		
		orderRepository.save(o1);
		
		
	}

}
