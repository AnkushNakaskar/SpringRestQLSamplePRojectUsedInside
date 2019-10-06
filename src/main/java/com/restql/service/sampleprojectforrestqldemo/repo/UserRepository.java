package com.restql.service.sampleprojectforrestqldemo.repo;

import com.restql.service.sampleprojectforrestqldemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ankushnakaskar
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
