package com.restql.service.sampleprojectforrestqldemo.prepared;

import com.restql.service.sampleprojectforrestqldemo.entity.AddressEntity;
import com.restql.service.sampleprojectforrestqldemo.entity.UserEntity;
import com.restql.service.sampleprojectforrestqldemo.repo.AddressRepo;
import com.restql.service.sampleprojectforrestqldemo.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ankushnakaskar
 */
@Component
@AllArgsConstructor
public class DataProvider implements CommandLineRunner {

    private UserRepository userRepository;

    private AddressRepo addressRepo;

    @Override
    @Transactional
    public void run(String... strings) {

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingName("Bon Vivant");
        addressEntity.setFlatNo("B-403");

        addressEntity = addressRepo.save(addressEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setAddressId(addressEntity.getAddressId());
        userEntity.setId(1L);
        userEntity.setName("Ankush");
        userRepository.save(userEntity);
    }
}
