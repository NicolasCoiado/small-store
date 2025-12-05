package dev.nvnk.SmallStore.controller.dto.response;

import dev.nvnk.SmallStore.entity.States;

public record AddressResponse (
        Long id,
        String cep,
        States state,
        String city,
        String neighborhood,
        String number
){}
