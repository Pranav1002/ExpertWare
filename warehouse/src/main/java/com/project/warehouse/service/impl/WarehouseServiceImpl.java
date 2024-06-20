package com.project.warehouse.service.impl;

import com.project.warehouse.Repository.WarehouseRepository;
import com.project.warehouse.dto.InventoryDto;
import com.project.warehouse.dto.OrderDto;
import com.project.warehouse.dto.WarehouseDetailsDto;
import com.project.warehouse.dto.WarehouseDto;
import com.project.warehouse.entity.Warehouse;
import com.project.warehouse.exception.ResourceNotFoundException;
import com.project.warehouse.exception.WarehouseAlreadyExistException;
import com.project.warehouse.externalService.InventoryService;
import com.project.warehouse.externalService.OrderService;
import com.project.warehouse.service.WarehouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ModelMapper mp;

    @Autowired
    private OrderService orderService;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public List<WarehouseDto> getAllWarehouses() {
        List<Warehouse> warehouses =  warehouseRepository.findAll();
        List<WarehouseDto> warehouseDtos = warehouses.stream().map(warehouse -> mp.map(warehouse, WarehouseDto.class)).toList();

        return warehouseDtos;
    }

    @Override
    public WarehouseDto getWarehouseById(Long id) {
        Warehouse wh =  warehouseRepository.findById(id).orElse(null);
        return mp.map(wh, WarehouseDto.class);
    }

    @Override
    public WarehouseDto saveWarehouse(WarehouseDto warehouseDto) throws WarehouseAlreadyExistException {
        Warehouse warehouse = mp.map(warehouseDto, Warehouse.class);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findByWarehouseCode(warehouse.getWarehouseCode());

        if(optionalWarehouse.isPresent()){
            throw new WarehouseAlreadyExistException("Warehouse already registered with given code : "+warehouse.getWarehouseCode());
        }

        Warehouse wh =  warehouseRepository.save(warehouse);
        return mp.map(wh, WarehouseDto.class);
    }

    @Override
    public WarehouseDto updateWarehouse(WarehouseDto warehouseDto) throws ResourceNotFoundException{
        String code = warehouseDto.getWarehouseCode();
        Warehouse warehouse = warehouseRepository.findByWarehouseCode(code).orElseThrow(()->new ResourceNotFoundException("Warehouse", "WarehouseCode", code));
        if(warehouse!=null) {
            Warehouse savedWarehouse = warehouseRepository.save(warehouse);
            return mp.map(savedWarehouse, WarehouseDto.class);
        }
        return null;
    }

    @Override
    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public WarehouseDetailsDto getWarehouseDetails(String code){
        Warehouse warehouse = warehouseRepository.findByWarehouseCode(code).orElseThrow(()->new ResourceNotFoundException("Warehouse", "WarehouseCode", code));

        WarehouseDetailsDto warehouseDetailsDto = mp.map(warehouse, WarehouseDetailsDto.class);

        Long warehouseId = warehouse.getWarehouseId();

        ResponseEntity<List<OrderDto>> orders = orderService.getOrdersByWarehouseId(warehouseId);

        System.out.println(orders);

        ResponseEntity<List<InventoryDto>> inventories = inventoryService.getItemsByWarehouseId(warehouseId);

        System.out.println(inventories);

        warehouseDetailsDto.setOrders(orders.getBody());

        warehouseDetailsDto.setInventories(inventories.getBody());

        return warehouseDetailsDto;


    }

}
