package com.project.order.controller;

import com.project.order.dto.OrderDto;
import com.project.order.entity.Order;
import com.project.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<OrderDto>> getOrdersByWarehouseId(@PathVariable Long warehouseId) {
        List<OrderDto> orderDtos =  orderService.getOrdersByWarehouseId(warehouseId);
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto orderDto = orderService.getOrderById(id);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto orderDto1 = orderService.saveOrder(orderDto);
        if(orderDto1!=null)
            return new ResponseEntity<>(orderDto1, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateWarehouse(@Valid @RequestBody OrderDto orderDto){
        OrderDto orderDto1 = orderService.updateOrder(orderDto);
        if(orderDto1!=null)
            return new ResponseEntity<>(orderDto1, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
