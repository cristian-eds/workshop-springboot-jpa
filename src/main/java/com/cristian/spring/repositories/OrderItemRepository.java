package com.cristian.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.spring.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
