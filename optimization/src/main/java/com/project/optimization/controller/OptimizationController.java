package com.project.optimization.controller;

import com.project.optimization.service.OptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/optimzation")
public class OptimizationController {

    @Autowired
    private OptimizationService optimizationService;

    @GetMapping("/storage/{warehouseId}")
    public String optimizeStorage(@PathVariable Long warehouseId) {
        return optimizationService.optimizeStorage(warehouseId);
    }

    @GetMapping("/retrieval/{warehouseId}")
    public String optimizeRetrieval(@PathVariable Long warehouseId) {
        return optimizationService.optimizeRetrieval(warehouseId);
    }


}
