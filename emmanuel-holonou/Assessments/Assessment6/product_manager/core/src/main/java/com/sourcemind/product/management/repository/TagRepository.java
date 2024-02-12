package com.sourcemind.product.management.repository;

import com.sourcemind.product.management.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
