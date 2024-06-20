package com.project.inventory.controller;

import com.project.inventory.dto.InventoryDto;
import com.project.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllItems() {
        return new ResponseEntity<>(inventoryService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<InventoryDto>> getItemsByWarehouseId(@PathVariable Long warehouseId) {
        return new ResponseEntity<>(inventoryService.getItemsByWarehouseId(warehouseId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getItemById(@PathVariable String id) {
        return new ResponseEntity<>(inventoryService.getItemById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryDto> createItem(@RequestBody InventoryDto item) {
        InventoryDto inventoryDto =  inventoryService.saveItem(item);
        if(inventoryDto!=null)
            return new ResponseEntity<>(inventoryDto, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<InventoryDto> updateWarehouse(@Valid @RequestBody InventoryDto inventoryDto){
        InventoryDto inventoryDto1 = inventoryService.updateItem(inventoryDto);
        if(inventoryDto1!=null)
            return new ResponseEntity<>(inventoryDto1, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        inventoryService.deleteItem(id);
    }

}
