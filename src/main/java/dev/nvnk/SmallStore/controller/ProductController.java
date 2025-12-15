package dev.nvnk.SmallStore.controller;

import dev.nvnk.SmallStore.controller.dto.request.ProductRequest;
import dev.nvnk.SmallStore.controller.dto.response.ProductResponse;
import dev.nvnk.SmallStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerProduct (@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = service.registerProduct(productRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("Message", "The product has been successfully registered.");
        response.put("Product", productResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findProductById (@PathVariable Long id){
        ProductResponse productResponse = service.findProductById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("Product", productResponse);

        return ResponseEntity.ok(response);
    }

}
