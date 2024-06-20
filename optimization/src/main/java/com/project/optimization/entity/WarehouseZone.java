package com.project.optimization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long warehouseId;
    @Column(nullable = false)
    private String zoneName;
    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false)
    private int currentLoad;

}
