package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.jpa.OrderEntity;
import com.example.orderservice.jpa.OrderRepository;
import com.example.orderservice.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        OrderEntity order = OrderEntity.builder()
                .orderId(UUID.randomUUID().toString())
                .productId(orderDto.getProductId())
                .qty(orderDto.getQty())
                .unitPrice(orderDto.getUnitPrice())
                .totalPrice(orderDto.getQty() * orderDto.getUnitPrice())
                .userId(orderDto.getUserId())
                .build();

        OrderEntity saved = orderRepository.save(order);

        return orderMapper.entity_to_dto(saved);
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId).orElseThrow(() -> new IllegalArgumentException("해당하는 주문이 없습니다."));
        return orderMapper.entity_to_dto(orderEntity);
    }

    @Override
    public List<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
