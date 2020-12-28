package com.amit.fruitshop.controllers;

import com.amit.fruitshop.domain.Customer;
import com.amit.fruitshop.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
