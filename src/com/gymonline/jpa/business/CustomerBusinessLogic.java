package com.gymonline.jpa.business;

import com.gymonline.jpa.repositories.CustomerRepository;

import javax.inject.Inject;

public class CustomerBusinessLogic {

    @Inject
    private CustomerRepository cur;
}
