package dev.nvnk.SmallStore.controller.dto.request;

import dev.nvnk.SmallStore.entity.Company;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CostumerRequest (
        @NotBlank
        String name,
        @Email
        String email,
        String cpf,
        @NotNull
        Company company
){}
