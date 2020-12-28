package com.amit.fruitshop.services;

import com.amit.fruitshop.domain.Customer;
import com.amit.fruitshop.exceptions.FSNotFoundException;
import com.amit.fruitshop.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void findAllReturnsDataIfExist() {
        Customer customer = new Customer();
        customer.setFirstName("Amit");
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(customer);
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        List<Customer> customers = customerService.findAll();

        assertEquals(customers.size(), 1);
        assertEquals(customers.get(0).getFirstName(), "Amit");
    }

    @Test
    void findAllThrowsExceptionIfNotExist() {
        List<Customer> mockCustomers = new ArrayList<>();
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        FSNotFoundException exception = assertThrows(FSNotFoundException.class, () -> customerService.findAll());
        assertEquals("No customers found", exception.getMessage());
    }
}