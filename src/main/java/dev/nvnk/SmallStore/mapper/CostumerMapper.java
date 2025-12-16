package dev.nvnk.SmallStore.mapper;

import dev.nvnk.SmallStore.controller.dto.request.CostumerRequest;
import dev.nvnk.SmallStore.controller.dto.response.CostumerResponse;
import dev.nvnk.SmallStore.entity.Costumer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CostumerMapper {
    public Costumer toEntity (CostumerRequest request){
        return Costumer
                .builder()
                .id(null)
                .name(request.name())
                .cpf(request.cpf())
                .email(request.email())
                .company(request.company())
                .createdAt(null)
                .build();
    }

    public CostumerResponse toResponse (Costumer entity){
        return new CostumerResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getCompany(),
                entity.getCreatedAt()
        );
    }
}
