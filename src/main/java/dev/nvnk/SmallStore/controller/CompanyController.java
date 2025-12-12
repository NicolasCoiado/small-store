package dev.nvnk.SmallStore.controller;

import dev.nvnk.SmallStore.controller.dto.request.CompanyRequest;
import dev.nvnk.SmallStore.controller.dto.response.CompanyResponse;
import dev.nvnk.SmallStore.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerCompany (@Valid @RequestBody CompanyRequest companyRequest){
        CompanyResponse companySaved = service.registerCompany(companyRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("Message", "The company has been successfully registered.");
        response.put("Company details", companySaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findCompanyById (@PathVariable Long id){
        CompanyResponse company = service.findCompanyById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("Company ", company);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replaceCompany (@PathVariable Long id, @Valid @RequestBody CompanyRequest companyRequest){
        CompanyResponse company = service.replaceCompany(id, companyRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("Message", "The company has successfully edited.");
        response.put("Company ", company);

        return ResponseEntity.ok(response);
    }

}
