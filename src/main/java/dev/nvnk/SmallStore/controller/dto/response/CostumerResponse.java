package dev.nvnk.SmallStore.controller.dto.response;

import dev.nvnk.SmallStore.entity.Company;

import java.time.LocalDateTime;

public record CostumerResponse (
        Integer id,
        String name,
        String email,
        String cpf,
        Company company,
        LocalDateTime createdAt
){}
