package com.project.inventory.repository;

import com.project.inventory.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    Optional<List<Inventory>> findInventoriesByWarehouseId(Long warehouseId);

}
