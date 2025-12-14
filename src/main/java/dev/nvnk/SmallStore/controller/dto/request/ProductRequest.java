package dev.nvnk.SmallStore.controller.dto.request;

import dev.nvnk.SmallStore.entity.Company;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
    @NotBlank
    String name,
    @NotNull
    BigDecimal price,
    @NotNull
    Integer stockQuantity,
    @NotNull
    Company company
) {}
