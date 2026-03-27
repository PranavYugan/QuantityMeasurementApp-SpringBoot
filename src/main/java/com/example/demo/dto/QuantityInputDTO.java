package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class QuantityInputDTO {

    @Valid
    @NotNull(message = "This quantity cannot be null")
    private QuantityDTO thisQuantity;

    @Valid
    private QuantityDTO thatQuantity;

    @Valid
    private QuantityDTO targetQuantity;

    public QuantityDTO getThisQuantity() {
        return thisQuantity;
    }

    public void setThisQuantity(QuantityDTO thisQuantity) {
        this.thisQuantity = thisQuantity;
    }

    public QuantityDTO getThatQuantity() {
        return thatQuantity;
    }

    public void setThatQuantity(QuantityDTO thatQuantity) {
        this.thatQuantity = thatQuantity;
    }

    public QuantityDTO getTargetQuantity() {
        return targetQuantity;
    }

    public void setTargetQuantity(QuantityDTO targetQuantity) {
        this.targetQuantity = targetQuantity;
    }
}