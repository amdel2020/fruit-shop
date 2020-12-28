package com.amit.fruitshop.services;

import com.amit.fruitshop.domain.Customer;
import com.amit.fruitshop.exceptions.FSNotFoundException;
import com.amit.fruitshop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.size() == 0) throw new FSNotFoundException("No customers found");

        return customers;
    }
}
