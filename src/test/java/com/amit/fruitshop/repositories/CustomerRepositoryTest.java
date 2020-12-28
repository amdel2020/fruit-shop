package com.amit.fruitshop.repositories;

import com.amit.fruitshop.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void findAll() {
        List<Customer> customers = customerRepository.findAll();
        assertEquals(customers.size(), 10);
    }
}