package com.example.demo.controller;

import com.example.demo.dto.QuantityInputDTO;
import com.example.demo.dto.QuantityMeasurementDTO;
import com.example.demo.service.IQuantityMeasurementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/add")
    public QuantityMeasurementDTO add(@Valid @RequestBody QuantityInputDTO input) {
        return service.add(input);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementDTO subtract(@Valid @RequestBody QuantityInputDTO input) {
        return service.subtract(input);
    }

    @PostMapping("/divide")
    public QuantityMeasurementDTO divide(@Valid @RequestBody QuantityInputDTO input) {
        return service.divide(input);
    }

    @PostMapping("/compare")
    public QuantityMeasurementDTO compare(@Valid @RequestBody QuantityInputDTO input) {
        return service.compare(input);
    }

    @PostMapping("/convert")
    public QuantityMeasurementDTO convert(@Valid @RequestBody QuantityInputDTO input) {
        return service.convert(input);
    }

    @GetMapping("/history/action/{action}")
    public List<QuantityMeasurementDTO> getByAction(@PathVariable String action) {
        return service.getByAction(action);
    }

    @GetMapping("/history/type/{type}")
    public List<QuantityMeasurementDTO> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping("/count/{action}")
    public long getCount(@PathVariable String action) {
        return service.getCount(action);
    }
}