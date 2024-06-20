package com.project.inventory.service.impl;

import com.project.inventory.dto.InventoryDto;
import com.project.inventory.entity.Inventory;
import com.project.inventory.exception.InventoryAlreadyExistException;
import com.project.inventory.exception.ResourceNotFoundException;
import com.project.inventory.repository.InventoryRepository;
import com.project.inventory.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ModelMapper mp;

    @Override
    public List<InventoryDto> getAllItems() {
        List<Inventory> inventories = inventoryRepository.findAll();

        List<InventoryDto> inventoryDtos = inventories.stream().map(inventory -> mp.map(inventory, InventoryDto.class)).toList();

        return inventoryDtos;
    }

    @Override
    public List<InventoryDto> getItemsByWarehouseId(Long warehouseId) {
        List<Inventory> inventories = inventoryRepository.findInventoriesByWarehouseId(warehouseId).orElseThrow(()->new ResourceNotFoundException("Inventory","warehouseId", warehouseId.toString()));

        List<InventoryDto> inventoryDtos = inventories.stream().map(inventory -> mp.map(inventory, InventoryDto.class)).toList();

        return inventoryDtos;
    }

    @Override
    public InventoryDto getItemById(String inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(()->new ResourceNotFoundException("Inventory","inventoryId", inventoryId.toString()));

        return mp.map(inventory, InventoryDto.class);
    }

    @Override
    public InventoryDto saveItem(InventoryDto inventoryDto) throws InventoryAlreadyExistException{
        Inventory inventory = mp.map(inventoryDto, Inventory.class);

        Optional<Inventory> optionalWarehouse = inventoryRepository.findById(inventory.getInventoryId());

        if(optionalWarehouse.isPresent()){
            throw new InventoryAlreadyExistException("Order already registered with given code : "+inventory.getInventoryId());
        }

        Inventory savedInventory =  inventoryRepository.save(inventory);

        return mp.map(savedInventory, InventoryDto.class);

    }

    @Override
    public InventoryDto updateItem(InventoryDto inventoryDto) throws ResourceNotFoundException{
        String inventoryId = inventoryDto.getInventoryId();

        Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(()->new ResourceNotFoundException("Inventory", "inventoryId", inventoryId.toString()));
        if(inventory!=null) {
            Inventory savedWarehouse = inventoryRepository.save(inventory);
            return mp.map(savedWarehouse, InventoryDto.class);
        }
        return null;
    }

    @Override
    public void deleteItem(String id) {
        inventoryRepository.deleteById(id);
    }
}
