package com.sourcemind.product.management.converter;

import com.sourcemind.product.management.domain.Product;
import com.sourcemind.product.management.dto.ProductResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    public ProductResponseDto convert(Product product){
        ModelMapper modelMapper = new ModelMapper();
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        return productResponseDto;
    }

    public List<ProductResponseDto> convert(List<Product> products){
        List<ProductResponseDto> converted = new ArrayList<>();
        for(Product product: products){
            converted.add(convert(product)) ;
        }
        return converted;
    }
}

