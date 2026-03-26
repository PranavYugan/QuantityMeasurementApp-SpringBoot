package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityInputDTO {
    
    @Valid
    @NotNull(message = "This quantity cannot be null")
    private QuantityDTO thisQuantity;
    
    @Valid
    private QuantityDTO thatQuantity;
    
    @Valid
    private QuantityDTO targetQuantity;
}