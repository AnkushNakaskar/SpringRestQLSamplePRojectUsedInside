package com.restql.service.sampleprojectforrestqldemo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ankushnakaskar
 */
@Data
public class UserBean implements Serializable {

    private Long id;

    private String name;

    private Address address;
}
