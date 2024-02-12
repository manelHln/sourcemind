package com.sourcemind.product.management.facade;

import com.sourcemind.product.management.domain.Product;
import com.sourcemind.product.management.dto.ProductRequestDto;
import com.sourcemind.product.management.dto.ProductResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductFacade {
    ProductResponseDto createProduct(ProductRequestDto requestDto);
    ProductResponseDto postImage(String imageBlobId, Long productId);
    ProductResponseDto getSingleProduct(String  productId);
    String deleteProduct(String  uuid);
    Page<Product> getAllProducts(int page, int size);
}
