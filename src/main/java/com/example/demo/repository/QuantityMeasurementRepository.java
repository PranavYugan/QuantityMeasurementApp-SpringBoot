package com.example.demo.repository;

import com.example.demo.entity.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {

    List<QuantityMeasurementEntity> findByAction(String action);

    List<QuantityMeasurementEntity> findByType(String type);

    List<QuantityMeasurementEntity> findByTimestampAfter(LocalDateTime timestamp);

    long countByAction(String action);

    @Query("SELECT q FROM QuantityMeasurementEntity q WHERE q.action = :action ORDER BY q.timestamp DESC")
    List<QuantityMeasurementEntity> findSuccessfulOperations(@Param("action") String action);

    List<QuantityMeasurementEntity> findByTypeAndAction(String type, String action);

    List<QuantityMeasurementEntity> findByExpressionContaining(String expression);
}
