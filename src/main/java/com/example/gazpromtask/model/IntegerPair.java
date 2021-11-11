package com.example.gazpromtask.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IntegerPair {
    @NotNull
    @Schema(description = "Первое число", example = "1")
    private Integer intA;

    @NotNull
    @Schema(description = "Второе число", example = "2")
    private Integer intB;

    public void checkBEqualZero() {
        if (intB == 0) throw new ArithmeticException("/ by zero");
    }
}
