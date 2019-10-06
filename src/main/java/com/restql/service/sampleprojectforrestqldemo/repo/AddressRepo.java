package com.restql.service.sampleprojectforrestqldemo.repo;

import com.restql.service.sampleprojectforrestqldemo.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ankushnakaskar
 */
public interface AddressRepo extends JpaRepository<AddressEntity, Long> {
}