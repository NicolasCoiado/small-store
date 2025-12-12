package dev.nvnk.SmallStore.service;

import dev.nvnk.SmallStore.controller.dto.request.CompanyRequest;
import dev.nvnk.SmallStore.controller.dto.response.CompanyResponse;
import dev.nvnk.SmallStore.entity.Company;
import dev.nvnk.SmallStore.exception.CompanyNotFoundException;
import dev.nvnk.SmallStore.mapper.CompanyMapper;
import dev.nvnk.SmallStore.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    public CompanyResponse registerCompany (CompanyRequest companyRequest){
        Company companySaved = repository.save(mapper.toEntity(companyRequest));
        return mapper.toResponse(companySaved);
    }

    public CompanyResponse findCompanyById (Long id){
        Company company = repository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found."));
        return mapper.toResponse(company);
    }

    public CompanyResponse replaceCompany (Long id, CompanyRequest companyRequest){
        Company company = repository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found."));
        company.setName(companyRequest.name());
        company.setCnpj(companyRequest.cnpj());
        return mapper.toResponse(repository.save(company));
    }

}
