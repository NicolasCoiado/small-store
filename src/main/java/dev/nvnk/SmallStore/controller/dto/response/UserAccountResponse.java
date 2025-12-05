package dev.nvnk.SmallStore.controller.dto.response;

import dev.nvnk.SmallStore.entity.Company;
import dev.nvnk.SmallStore.entity.UserRole;

import java.time.LocalDateTime;

public record UserAccountResponse (
        Long id,
        String name,
        String email,
        String password,
        String cpf,
        UserRole role,
        Company company,
        LocalDateTime createdAt
){}
