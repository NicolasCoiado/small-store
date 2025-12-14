package dev.nvnk.SmallStore.service;

import dev.nvnk.SmallStore.controller.dto.request.ProductRequest;
import dev.nvnk.SmallStore.controller.dto.response.ProductResponse;
import dev.nvnk.SmallStore.entity.Product;
import dev.nvnk.SmallStore.mapper.ProductMapper;
import dev.nvnk.SmallStore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponse registerProduct (ProductRequest request){
        Product productSaved = repository.save(mapper.toEntity(request));
        return mapper.toResponse(productSaved);
    }
}