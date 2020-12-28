package com.amit.fruitshop.controllers;

import com.amit.fruitshop.domain.Customer;
import com.amit.fruitshop.exceptions.FSNotFoundException;
import com.amit.fruitshop.services.CategoryService;
import com.amit.fruitshop.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    void getCustomersReturnsOkIfDataFound() throws Exception {

        Customer customer = new Customer();
        customer.setFirstName("Amit");
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(customer);
        when(customerService.findAll()).thenReturn(mockCustomers);

        mvc.perform(get("/customers").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(mockCustomers)));

        verify(customerService, times(1)).findAll();
    }

    @Test
    void getCustomersReturns404IfDataNotFound() throws Exception {
        when(customerService.findAll()).thenThrow(FSNotFoundException.class);

        mvc.perform(get("/customers").contentType("application/json"))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).findAll();
    }
}