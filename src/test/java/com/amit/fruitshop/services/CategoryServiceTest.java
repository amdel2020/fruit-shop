package com.amit.fruitshop.services;

import com.amit.fruitshop.domain.Category;
import com.amit.fruitshop.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    CategoryService categoryService;

    @Mock
    public CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void findAll() {
        //Arrange
        Category category = new Category();
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(category);
        when(categoryRepository.findAll()).thenReturn(mockCategories);

        // Act
        List<Category> categories = categoryService.findAll();

        // Assert
        assertEquals(categories.size(), 1);
    }
}