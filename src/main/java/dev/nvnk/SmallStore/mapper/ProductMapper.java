package dev.nvnk.SmallStore.mapper;

import dev.nvnk.SmallStore.controller.dto.request.ProductRequest;
import dev.nvnk.SmallStore.controller.dto.response.ProductResponse;
import dev.nvnk.SmallStore.entity.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductMapper {
    public ProductResponse toResponse (Product entity){
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getStockQuantity(),
                entity.getCompany()
        );
    }

    public Product toEntity (ProductRequest request){
        return Product
                .builder()
                .id(null)
                .name(request.name())
                .price(request.price())
                .stockQuantity(request.stockQuantity())
                .company(request.company())
                .build();
    }
}
