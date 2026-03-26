package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "quantity_measurement",
    indexes = {
        @Index(name = "idx_action", columnList = "action"),
        @Index(name = "idx_type", columnList = "type"),
        @Index(name = "idx_timestamp", columnList = "timestamp")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "expression", nullable = false)
    private String expression;

    @Column(name = "result")
    private Double result;

    @Column(name = "result_string", columnDefinition = "TEXT")
    private String resultString;

    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp;

    @PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
    }
}