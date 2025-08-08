package com.myhomecraft.order_service.mapper;

import com.myhomecraft.order_service.dto.OrderDTO;
import com.myhomecraft.order_service.entity.Order;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setCartId(order.getCartId());
        return dto;
    }

    public static Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setTotalAmount(dto.getTotalAmount());
        order.setOrderDate(dto.getOrderDate());
        order.setStatus(dto.getStatus());
        order.setCartId(dto.getCartId());
        return order;
    }
}
