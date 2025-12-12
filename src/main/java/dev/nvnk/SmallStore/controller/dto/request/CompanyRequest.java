package dev.nvnk.SmallStore.controller.dto.request;

import dev.nvnk.SmallStore.entity.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyRequest(
        @NotBlank
        String cnpj,
        @NotBlank
        String name,
        @NotNull
        Address address
) {}
