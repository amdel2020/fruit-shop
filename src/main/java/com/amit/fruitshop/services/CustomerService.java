package com.amit.fruitshop.services;

import com.amit.fruitshop.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
