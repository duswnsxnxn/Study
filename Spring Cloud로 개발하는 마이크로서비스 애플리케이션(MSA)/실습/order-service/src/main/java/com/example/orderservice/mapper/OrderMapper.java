package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.jpa.OrderEntity;
import com.example.orderservice.vo.RequestOrder;
import com.example.orderservice.vo.ResponseOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto entity_to_dto(OrderEntity orderEntity) {

        return OrderDto.builder()
                .productId(orderEntity.getProductId())
                .qty(orderEntity.getQty())
                .unitPrice(orderEntity.getUnitPrice())
                .totalPrice(orderEntity.getTotalPrice())
                .orderId(orderEntity.getOrderId())
                .userId(orderEntity.getUserId())
                .build();
    }

    public OrderDto request_to_dto(RequestOrder requestOrder) {

        return OrderDto.builder()
                .productId(requestOrder.getProductId())
                .qty(requestOrder.getQty())
                .unitPrice(requestOrder.getUnitPrice())
                .totalPrice(requestOrder.getQty() * requestOrder.getUnitPrice())
                .build();
    }

    public ResponseOrder dto_to_response(OrderDto orderDto) {

        return ResponseOrder.builder()
                .productId(orderDto.getProductId())
                .qty(orderDto.getQty())
                .unitPrice(orderDto.getUnitPrice())
                .totalPrice(orderDto.getTotalPrice())
                .orderId(orderDto.getOrderId())
                .build();
    }

    public ResponseOrder entity_to_response(OrderEntity orderEntity) {

        return ResponseOrder.builder()
                .productId(orderEntity.getProductId())
                .qty(orderEntity.getQty())
                .unitPrice(orderEntity.getUnitPrice())
                .totalPrice(orderEntity.getTotalPrice())
                .createdAt(orderEntity.getCreatedAt())
                .orderId(orderEntity.getOrderId())
                .build();
    }

    public List<ResponseOrder> orderEntities_to_responseOrders(List<OrderEntity> orderEntities) {

        return orderEntities.stream()
                .map(this::entity_to_response)
                .collect(Collectors.toList());
    }
}
