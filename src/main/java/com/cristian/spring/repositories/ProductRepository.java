package com.cristian.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.spring.entities.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
