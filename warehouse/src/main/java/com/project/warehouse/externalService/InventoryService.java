package com.project.warehouse.externalService;

import com.project.warehouse.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("inventory")
public interface InventoryService {

    @GetMapping("api/inventory/warehouse/{warehouseId}")
    public ResponseEntity<List<InventoryDto>> getItemsByWarehouseId(@PathVariable Long warehouseId);

}
