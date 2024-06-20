package com.project.optimization.repository;

import com.project.optimization.entity.OptimizationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptimizationResultRepository extends JpaRepository<OptimizationResult, Long> {
}
