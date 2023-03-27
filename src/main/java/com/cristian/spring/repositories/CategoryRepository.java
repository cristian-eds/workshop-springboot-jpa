package com.cristian.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.spring.entities.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {

}
