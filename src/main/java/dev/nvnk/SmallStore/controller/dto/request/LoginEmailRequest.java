package dev.nvnk.SmallStore.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginEmailRequest(
        @Email
        String email,
        @NotBlank
        String password
) {}
