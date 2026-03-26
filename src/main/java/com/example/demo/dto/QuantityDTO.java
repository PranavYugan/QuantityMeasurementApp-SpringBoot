package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityDTO {

    @NotNull(message = "Value cannot be null")
    private Double value;

    @NotNull(message = "Symbol cannot be null")
    @NotEmpty(message = "Symbol cannot be empty")
    private String symbol;

    @NotNull(message = "Label cannot be null")
    @NotEmpty(message = "Label cannot be empty")
    private String label;

    @NotNull(message = "Type cannot be null")
    @NotEmpty(message = "Type cannot be empty")
    @Pattern(
        regexp = "length|volume|weight|temperature",
        message = "Type must be one of: length, volume, weight, temperature"
    )
    private String type;
}