package com.amit.fruitshop.repositories;

import com.amit.fruitshop.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        assertEquals(categories.size(), 4);
    }

    @Test
    void findByName() throws Exception {
        Optional<Category> category = categoryRepository.findByName("Fruits");

        if (category.isEmpty()) {
            throw new Exception();
        }

        assertEquals(category.get().getName(), "Fruits");
    }
}