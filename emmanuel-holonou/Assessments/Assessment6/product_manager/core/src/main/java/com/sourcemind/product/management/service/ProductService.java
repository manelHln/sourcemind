package com.sourcemind.product.management.service;

import com.sourcemind.product.management.converter.ProductConverter;
import com.sourcemind.product.management.domain.Product;
import com.sourcemind.product.management.domain.Tag;
import com.sourcemind.product.management.dto.ProductRequestDto;
import com.sourcemind.product.management.dto.ProductResponseDto;
import com.sourcemind.product.management.repository.ProductRepository;
import com.sourcemind.product.management.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ProductConverter productConverter;


    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setImageBlobId(UUID.randomUUID().toString());
        product.setOwnerUsername(requestDto.getOwnerName());
        if(!requestDto.getTags().isEmpty()){
            Set<Tag> tags = new HashSet<>();
            requestDto.getTags().stream().map(e -> {
                Tag tag = new Tag();
                tag.setType(e.getType());
                Tag created = tagRepository.save(tag);
                return  tags.add(created);
            });
            product.setTags(requestDto.getTags());
        }
        Product savedProduct = productRepository.save(product);
        return productConverter.convert(savedProduct);
    }

    public ProductResponseDto attachImageToProduct(String imageBlobId, Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.setImageBlobId(imageBlobId);
            return productConverter.convert(productRepository.save(product));
        }
        return null;
    }


    // This gives all needed information (total number of pages ...)

    public Page<Product> getAllUserProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }


    public ProductResponseDto getProduct(String  uuid) {
        Product product = productRepository.findByImageBlobId(uuid).orElseThrow();
        return productConverter.convert(product);
    }

    public String deleteProduct(String  uuid) {
        productRepository.deleteByImageBlobId(uuid);
        return "Product deleted successfuly";
    }
}
