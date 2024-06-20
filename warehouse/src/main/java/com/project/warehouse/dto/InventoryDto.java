package com.project.warehouse.dto;

import lombok.Data;

@Data
public class InventoryDto {

    private String inventoryId;
    private Long warehouseId;
    private String productName;
    private int quantity;

}
