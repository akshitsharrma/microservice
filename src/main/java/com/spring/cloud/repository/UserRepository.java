package com.spring.cloud.repository;

import com.spring.cloud.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
   UserEntity findByEmail(String email);
}
