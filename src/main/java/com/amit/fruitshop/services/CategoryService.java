package com.amit.fruitshop.services;

import com.amit.fruitshop.domain.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findByName(String name);
}
