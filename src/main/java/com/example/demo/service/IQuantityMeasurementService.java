package com.example.demo.service;

import com.example.demo.dto.QuantityInputDTO;
import com.example.demo.dto.QuantityMeasurementDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO add(QuantityInputDTO input);

    QuantityMeasurementDTO subtract(QuantityInputDTO input);

    QuantityMeasurementDTO divide(QuantityInputDTO input);

    QuantityMeasurementDTO compare(QuantityInputDTO input);

    QuantityMeasurementDTO convert(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getByAction(String action);

    List<QuantityMeasurementDTO> getByType(String type);

    long getCount(String action);
}