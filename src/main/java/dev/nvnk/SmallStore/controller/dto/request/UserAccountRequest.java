package dev.nvnk.SmallStore.controller.dto.request;

import dev.nvnk.SmallStore.entity.Company;
import dev.nvnk.SmallStore.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserAccountRequest(
        @NotBlank
        @Size(min = 4, message = "The name must contain at least 4 characters.")
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 6, message = "The password must contain at least 6 characters.")
        String password,
        @NotBlank
        String cpf,
        @NotNull
        UserRole role,
        @NotNull
        Company company
){}
