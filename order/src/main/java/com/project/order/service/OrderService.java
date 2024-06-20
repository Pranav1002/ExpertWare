package com.project.order.service;

import com.project.order.dto.OrderDto;

import java.util.List;

public interface OrderService {

    public List<OrderDto> getAllOrders();

    public List<OrderDto> getOrdersByWarehouseId(Long warehouseId);

    public OrderDto getOrderById(Long id);

    public OrderDto saveOrder(OrderDto orderDto);

    public OrderDto updateOrder(OrderDto orderDto);

    public void deleteOrder(Long id);

}
