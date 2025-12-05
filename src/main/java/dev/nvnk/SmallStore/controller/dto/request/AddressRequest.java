package dev.nvnk.SmallStore.controller.dto.request;

import dev.nvnk.SmallStore.entity.States;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRequest (
        @NotBlank
        String cep,
        @NotNull
        States state,
        @NotBlank
        String city,
        @NotBlank
        String neighborhood,
        @NotBlank
        String number
){}
