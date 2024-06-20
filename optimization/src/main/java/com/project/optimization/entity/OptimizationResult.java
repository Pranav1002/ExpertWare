package com.project.optimization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long warehouseId;
    @Column(nullable = false)
    private String optimizationType; // e.g., "Storage", "Retrieval"
    @Column(nullable = false)
    private String details;
    @Column(nullable = false)
    private LocalDateTime timestamp;
}
