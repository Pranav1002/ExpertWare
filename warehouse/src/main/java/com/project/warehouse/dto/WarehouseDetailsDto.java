package com.project.warehouse.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class WarehouseDetailsDto {

    @Column(nullable = false, unique = true)
    private String warehouseCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private int capacity;

    private List<OrderDto> orders;

    private List<InventoryDto> inventories;


}
