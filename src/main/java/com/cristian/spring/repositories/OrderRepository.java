package com.cristian.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.spring.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
