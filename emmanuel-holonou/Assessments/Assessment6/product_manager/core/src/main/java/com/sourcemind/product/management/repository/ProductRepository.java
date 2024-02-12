package com.sourcemind.product.management.repository;

import com.sourcemind.product.management.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByImageBlobId(String uuid);
    Optional<Product> deleteByImageBlobId(String  uuid);
}
