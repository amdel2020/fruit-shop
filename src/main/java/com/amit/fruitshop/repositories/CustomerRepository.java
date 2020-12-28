package com.amit.fruitshop.repositories;

import com.amit.fruitshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
