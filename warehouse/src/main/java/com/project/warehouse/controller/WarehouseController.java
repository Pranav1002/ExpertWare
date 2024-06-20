package com.project.warehouse.controller;

import com.project.warehouse.dto.WarehouseDetailsDto;
import com.project.warehouse.dto.WarehouseDto;
import com.project.warehouse.entity.Warehouse;
import com.project.warehouse.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/warehouse")
@Validated
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<WarehouseDto>> getAllWarehouses() {
        return new ResponseEntity<>(warehouseService.getAllWarehouses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDto> getWarehouseById(@PathVariable Long id) {
        WarehouseDto warehouseDto = warehouseService.getWarehouseById(id);
        return new ResponseEntity<>(warehouseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WarehouseDto> createWarehouse(@Valid @RequestBody WarehouseDto warehouseDto) {
        WarehouseDto warehouseDto1 = warehouseService.saveWarehouse(warehouseDto);
        if(warehouseDto1==null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(warehouseDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<WarehouseDto> updateWarehouse(@Valid @RequestBody WarehouseDto warehouseDto){
        WarehouseDto warehouseDto1 = warehouseService.updateWarehouse(warehouseDto);
        if(warehouseDto1!=null)
            return new ResponseEntity<>(warehouseDto1, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
    }

    @GetMapping("/details/{code}")
    public ResponseEntity<WarehouseDetailsDto> getWarehouseDetails(@PathVariable String code){
        WarehouseDetailsDto warehouseDetailsDto =  warehouseService.getWarehouseDetails(code);

        return new ResponseEntity<>(warehouseDetailsDto, HttpStatus.OK);
    }

}
