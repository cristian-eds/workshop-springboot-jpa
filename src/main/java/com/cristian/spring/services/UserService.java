package com.cristian.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.spring.entities.User;
import com.cristian.spring.repositories.UserRepository;
import com.cristian.spring.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insertUser(User userObj) {
		return repository.save(userObj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User userObj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, userObj);
		return repository.save(entity);
	}

	public void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
