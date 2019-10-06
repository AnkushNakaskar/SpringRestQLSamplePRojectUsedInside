package com.restql.service.sampleprojectforrestqldemo;

import com.restql.service.sampleprojectforrestqldemo.bean.Address;
import com.restql.service.sampleprojectforrestqldemo.bean.UserBean;
import com.restql.service.sampleprojectforrestqldemo.entity.UserEntity;
import com.restql.service.sampleprojectforrestqldemo.repo.AddressRepo;
import com.restql.service.sampleprojectforrestqldemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankushnakaskar
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepo addressRepo;


    @GetMapping
    public List<UserBean> getUserDetails() {
        List<UserEntity> users = userRepository.findAll();
        List<UserBean> userBeanList = new ArrayList<>();
        users.stream().forEach(user -> {
            UserBean bean = new UserBean();
            bean.setName(user.getName());
            bean.setId(user.getId());
            addressRepo.findById(user.getAddressId()).ifPresent(addressEntity -> {
                Address address =new Address();
                address.setAddressId(addressEntity.getAddressId());
                address.setFlatNo(addressEntity.getFlatNo());
                address.setBuildingName(addressEntity.getBuildingName());
                bean.setAddress(address);
            });
            userBeanList.add(bean);
        });
        return userBeanList;
    }
}
