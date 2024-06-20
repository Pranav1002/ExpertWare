package com.project.warehouse.service;

import com.project.warehouse.dto.WarehouseDetailsDto;
import com.project.warehouse.dto.WarehouseDto;
import com.project.warehouse.entity.Warehouse;

import java.util.List;

public interface WarehouseService {

    public List<WarehouseDto> getAllWarehouses();

    public WarehouseDto getWarehouseById(Long id);

    public WarehouseDto saveWarehouse(WarehouseDto warehouseDto);

    public WarehouseDto updateWarehouse(WarehouseDto warehouseDto);

    public void deleteWarehouse(Long id);

    public WarehouseDetailsDto getWarehouseDetails(String code);
}
