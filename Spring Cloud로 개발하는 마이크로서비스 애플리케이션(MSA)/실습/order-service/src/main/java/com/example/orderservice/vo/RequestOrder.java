package com.example.orderservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrder {

    public String productId;
    public Integer qty;
    public Integer unitPrice;
}
