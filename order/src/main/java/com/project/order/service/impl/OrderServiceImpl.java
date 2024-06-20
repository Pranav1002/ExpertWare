package com.project.order.service.impl;

import com.project.order.dto.OrderDto;
import com.project.order.entity.Order;
import com.project.order.exception.OrderAlreadyExistException;
import com.project.order.exception.ResourceNotFoundException;
import com.project.order.repository.OrderRepository;
import com.project.order.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper mp;

    @Override
    public List<OrderDto> getAllOrders() {

        List<Order> orders = orderRepository.findAll();

        List<OrderDto> orderDtos = orders.stream().map(order -> mp.map(order, OrderDto.class)).toList();

        return orderDtos;
    }

    @Override
    public List<OrderDto> getOrdersByWarehouseId(Long warehouseId) {

        List<Order> orders = orderRepository.findOrdersByWarehouseId(warehouseId).orElseThrow(()-> new ResourceNotFoundException("Order","warehouseId", warehouseId.toString()));

        List<OrderDto> orderDtos = orders.stream().map(order -> mp.map(order, OrderDto.class)).toList();

        return orderDtos;

    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order","orderId", orderId.toString()));
        return mp.map(order, OrderDto.class);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) throws OrderAlreadyExistException{

        Order order = mp.map(orderDto, Order.class);

        Optional<Order> optionalWarehouse = orderRepository.findById(order.getOrderId());

        if(optionalWarehouse.isPresent()){
            throw new OrderAlreadyExistException("Order already registered with given code : "+order.getOrderId());
        }

        Order savedOrder =  orderRepository.save(order);

        return mp.map(savedOrder, OrderDto.class);

    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) throws ResourceNotFoundException{
        Long orderId = orderDto.getOrderId();
        Order order = orderRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order", "orderId", orderId.toString()));
        if(order!=null) {
            Order savedOrder = orderRepository.save(order);
            return mp.map(savedOrder, OrderDto.class);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order","orderId", orderId.toString()));

        orderRepository.delete(order);

    }
}
