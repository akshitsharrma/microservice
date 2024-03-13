package com.spring.cloud.repository;

import com.spring.cloud.model.CuponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuponRepository extends JpaRepository<CuponEntity,Long> {
    List<CuponEntity> findByCode(String code);

}
