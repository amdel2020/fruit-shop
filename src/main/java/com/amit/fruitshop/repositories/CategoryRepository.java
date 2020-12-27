package com.amit.fruitshop.repositories;

import com.amit.fruitshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
