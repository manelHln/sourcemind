package com.sourcemind.product.management.controller;

import com.sourcemind.product.management.dto.ProductRequestDto;
import com.sourcemind.product.management.dto.ProductResponseDto;
import com.sourcemind.product.management.facade.ProductFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductFacadeImpl productFacade;

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto request) {
        return ResponseEntity.ok(productFacade.createProduct(request));
    }

    @PostMapping("/products/{uuid}/image")
    public ResponseEntity<ProductResponseDto> postImage(@PathVariable String uuid, @RequestBody Long productId) {
        return ResponseEntity.ok(productFacade.postImage(uuid, productId));
    }

    @GetMapping("/products/{uuid}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable String uuid) {
        return ResponseEntity.ok(productFacade.getSingleProduct(uuid));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable String id) {
        return null;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return null;
    }
}
