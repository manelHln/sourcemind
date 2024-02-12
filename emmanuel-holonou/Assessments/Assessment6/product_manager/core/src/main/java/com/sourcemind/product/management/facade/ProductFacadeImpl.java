package com.sourcemind.product.management.facade;

import com.sourcemind.product.management.domain.Product;
import com.sourcemind.product.management.dto.ProductRequestDto;
import com.sourcemind.product.management.dto.ProductResponseDto;
import com.sourcemind.product.management.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class ProductFacadeImpl implements ProductFacade {

    private final Logger logger = LoggerFactory.getLogger(ProductFacadeImpl.class);

    @Autowired
    private ProductService productService;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        logger.info("Creating a new product {}", requestDto);
        return productService.createProduct(requestDto);
    }

    @Override
    public ProductResponseDto postImage(String imageBlobId, Long productId) {
        logger.info("Post image {}", imageBlobId);
        return productService.attachImageToProduct(imageBlobId, productId);
    }

    @Override
    public ProductResponseDto getSingleProduct(String uuid) {
        logger.info("Getting a single product {}", uuid);
        return productService.getProduct(uuid);
    }

    @Override
    public String deleteProduct(String  uuid) {
        logger.info("Delete product {}", uuid);
        return productService.deleteProduct(uuid);
    }

    @Override
    public Page<Product> getAllProducts(int page, int size) {
        logger.info("Get all products paginated");
        return productService.getAllUserProducts(page, size);
    }
}
