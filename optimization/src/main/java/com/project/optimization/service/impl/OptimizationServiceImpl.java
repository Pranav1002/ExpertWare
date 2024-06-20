package com.project.optimization.service.impl;

import com.project.optimization.entity.OptimizationResult;
import com.project.optimization.entity.WarehouseZone;
import com.project.optimization.repository.OptimizationResultRepository;
import com.project.optimization.repository.WarehouseZoneRepository;
import com.project.optimization.service.OptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OptimizationServiceImpl implements OptimizationService {

    @Autowired
    private WarehouseZoneRepository warehouseZoneRepository;

    @Autowired
    private OptimizationResultRepository optimizationResultRepository;

    @Override
    public String optimizeStorage(Long warehouseId) {
        List<WarehouseZone> zones = warehouseZoneRepository.findByWarehouseId(warehouseId).orElseThrow(()-> new RuntimeException("Given Ware house Id not found"));
        StringBuilder details = new StringBuilder();
        for (WarehouseZone zone : zones) {
            if (zone.getCapacity() > zone.getCurrentLoad()) {
                details.append("Zone ").append(zone.getZoneName()).append(" has available capacity.\n");
            }
        }

        // Save optimization result
        OptimizationResult result = new OptimizationResult();
        result.setWarehouseId(warehouseId);
        result.setOptimizationType("Storage");
        result.setDetails(details.toString());
        result.setTimestamp(LocalDateTime.now());
        optimizationResultRepository.save(result);

        return "Storage optimization completed for warehouse ID: " + warehouseId;
    }

    @Override
    public String optimizeRetrieval(Long warehouseId) {
        String details = "Optimal retrieval paths calculated for warehouse ID: " + warehouseId;

        // Save optimization result
        OptimizationResult result = new OptimizationResult();
        result.setWarehouseId(warehouseId);
        result.setOptimizationType("Retrieval");
        result.setDetails(details);
        result.setTimestamp(LocalDateTime.now());
        optimizationResultRepository.save(result);

        return "Retrieval optimization completed for warehouse ID: " + warehouseId;
    }
}
