package com.example.SpringBoot.dtos;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name, @Nonnull BigDecimal value) {


}
