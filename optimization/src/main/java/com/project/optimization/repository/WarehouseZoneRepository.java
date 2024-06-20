package com.project.optimization.repository;

import com.project.optimization.entity.WarehouseZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseZoneRepository extends JpaRepository<WarehouseZone, Long> {

    Optional<List<WarehouseZone>> findByWarehouseId(Long warehouseId);

}
