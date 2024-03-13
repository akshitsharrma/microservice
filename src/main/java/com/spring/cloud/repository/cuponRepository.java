package com.spring.cloud.repository;

import com.spring.cloud.model.CuponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cuponRepository extends JpaRepository<CuponEntity,Long> {
}
