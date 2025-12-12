package dev.nvnk.SmallStore.mapper;

import dev.nvnk.SmallStore.controller.dto.request.CompanyRequest;
import dev.nvnk.SmallStore.controller.dto.response.CompanyResponse;
import dev.nvnk.SmallStore.entity.Company;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyMapper {
    public Company toEntity (CompanyRequest request){
        return  Company
                .builder()
                .id(null)
                .cnpj(request.cnpj())
                .name(request.name())
                .address(request.address())
                .build();
    }

    public CompanyResponse toResponse (Company entity){
        return new CompanyResponse(
                entity.getId(),
                entity.getCnpj(),
                entity.getName(),
                entity.getAddress(),
                entity.getCreatedAt()
        );
    }
}
