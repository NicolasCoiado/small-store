package dev.nvnk.SmallStore.controller.dto.response;

import dev.nvnk.SmallStore.entity.Company;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        BigDecimal price,
        Integer stockQuantity,
        Company company
) {
}
