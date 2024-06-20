package com.project.warehouse.externalService;

import com.project.warehouse.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("order")
public interface OrderService {

    @GetMapping("/api/order/warehouse/{warehouseId}")
    public ResponseEntity<List<OrderDto>> getOrdersByWarehouseId(@PathVariable Long warehouseId);

}
