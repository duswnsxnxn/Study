package com.example.orderservice.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderEntity, Long>{
    Optional<OrderEntity> findByOrderId(String orderId);
    List<OrderEntity> findByUserId(String userId);
}
