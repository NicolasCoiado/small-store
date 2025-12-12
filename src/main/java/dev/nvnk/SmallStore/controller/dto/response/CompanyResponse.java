package dev.nvnk.SmallStore.controller.dto.response;

import dev.nvnk.SmallStore.entity.Address;

import java.time.LocalDateTime;

public record CompanyResponse(
        Long id,
        String cnpj,
        String name,
        Address address,
        LocalDateTime createdAt
) {}
