package com.example.demo.service;

import com.example.demo.dto.QuantityInputDTO;
import com.example.demo.dto.QuantityMeasurementDTO;
import com.example.demo.entity.QuantityMeasurementEntity;
import com.example.demo.exception.QuantityMeasurementException;
import com.example.demo.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
    public QuantityMeasurementDTO add(QuantityInputDTO input) {

        if (!input.getThisQuantity().getType()
                .equalsIgnoreCase(input.getThatQuantity().getType())) {
            throw new QuantityMeasurementException("Types must be same");
        }

        double result = input.getThisQuantity().getValue() + input.getThatQuantity().getValue();

        QuantityMeasurementEntity e = new QuantityMeasurementEntity();
        e.setType(input.getThisQuantity().getType());
        e.setAction("ADD");
        e.setExpression(input.getThisQuantity().getValue() + " + " + input.getThatQuantity().getValue());
        e.setResult(result);
        e.setResultString(String.valueOf(result));

        repository.save(e);

        return map(e);
    }

    @Override
    public QuantityMeasurementDTO subtract(QuantityInputDTO input) {

        if (!input.getThisQuantity().getType()
                .equalsIgnoreCase(input.getThatQuantity().getType())) {
            throw new QuantityMeasurementException("Types must be same");
        }

        double result = input.getThisQuantity().getValue() - input.getThatQuantity().getValue();

        QuantityMeasurementEntity e = new QuantityMeasurementEntity();
        e.setType(input.getThisQuantity().getType());
        e.setAction("SUBTRACT");
        e.setExpression(input.getThisQuantity().getValue() + " - " + input.getThatQuantity().getValue());
        e.setResult(result);
        e.setResultString(String.valueOf(result));

        repository.save(e);

        return map(e);
    }

    @Override
    public QuantityMeasurementDTO divide(QuantityInputDTO input) {

        if (!input.getThisQuantity().getType()
                .equalsIgnoreCase(input.getThatQuantity().getType())) {
            throw new QuantityMeasurementException("Types must be same");
        }

        double v2 = input.getThatQuantity().getValue();

        if (v2 == 0) {
            throw new QuantityMeasurementException("Cannot divide by zero");
        }

        double result = input.getThisQuantity().getValue() / v2;

        QuantityMeasurementEntity e = new QuantityMeasurementEntity();
        e.setType(input.getThisQuantity().getType());
        e.setAction("DIVIDE");
        e.setExpression(input.getThisQuantity().getValue() + " / " + input.getThatQuantity().getValue());
        e.setResult(result);
        e.setResultString(String.valueOf(result));

        repository.save(e);

        return map(e);
    }

    @Override
    public QuantityMeasurementDTO compare(QuantityInputDTO input) {

        double v1 = input.getThisQuantity().getValue();
        double v2 = input.getThatQuantity().getValue();

        String res = v1 == v2 ? "Equal" : (v1 > v2 ? "Greater" : "Lesser");

        QuantityMeasurementEntity e = new QuantityMeasurementEntity();
        e.setType(input.getThisQuantity().getType());
        e.setAction("COMPARE");
        e.setExpression(v1 + " vs " + v2);
        e.setResult(v1);
        e.setResultString(res);

        repository.save(e);

        return map(e);
    }

    @Override
    public QuantityMeasurementDTO convert(QuantityInputDTO input) {

        double value = input.getThisQuantity().getValue();

        QuantityMeasurementEntity e = new QuantityMeasurementEntity();
        e.setType(input.getThisQuantity().getType());
        e.setAction("CONVERT");
        e.setExpression(value + " " + input.getThisQuantity().getSymbol());
        e.setResult(value);
        e.setResultString(String.valueOf(value));

        repository.save(e);

        return map(e);
    }

    @Override
    public List<QuantityMeasurementDTO> getByAction(String action) {
        return repository.findByAction(action)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuantityMeasurementDTO> getByType(String type) {
        return repository.findByType(type)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public long getCount(String action) {
        return repository.countByAction(action);
    }

    private QuantityMeasurementDTO map(QuantityMeasurementEntity e) {
        QuantityMeasurementDTO d = new QuantityMeasurementDTO();
        d.setId(e.getId());
        d.setType(e.getType());
        d.setAction(e.getAction());
        d.setExpression(e.getExpression());
        d.setResult(e.getResult());
        d.setResultString(e.getResultString());
        d.setTimestamp(e.getTimestamp());
        return d;
    }
}