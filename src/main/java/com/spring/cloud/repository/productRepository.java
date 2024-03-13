package com.spring.cloud.repository;

import com.spring.cloud.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<ProductEntity, Long> {
}
