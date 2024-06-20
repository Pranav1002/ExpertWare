package com.project.inventory.service;

import com.project.inventory.dto.InventoryDto;

import java.util.List;

public interface InventoryService {

    public List<InventoryDto> getAllItems();

    public List<InventoryDto> getItemsByWarehouseId(Long warehouseId);

    public InventoryDto getItemById(String id);

    public InventoryDto saveItem(InventoryDto inventoryDto);

    public InventoryDto updateItem(InventoryDto inventoryDto);

    public void deleteItem(String id);

}
