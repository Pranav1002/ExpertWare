package com.project.warehouse.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class WarehouseDto {

    @Column(nullable = false, unique = true)
    private String warehouseCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private int capacity;

}
