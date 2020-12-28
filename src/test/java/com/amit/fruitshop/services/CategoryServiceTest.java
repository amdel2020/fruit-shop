package com.amit.fruitshop.services;

import com.amit.fruitshop.domain.Category;
import com.amit.fruitshop.exceptions.FSNotFoundException;
import com.amit.fruitshop.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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
    void findAllReturnsDataIfExist() {
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

    @Test
    void findAllThrowsExceptionIfNotExist() {
        //Arrange
        List<Category> mockCategories = new ArrayList<>();
        when(categoryRepository.findAll()).thenReturn(mockCategories);

        // Act
        FSNotFoundException exception = assertThrows(FSNotFoundException.class, () -> categoryService.findAll());

        // Assert
        assertEquals("No categories found", exception.getMessage());
    }

    @Test
    void findByNameReturnsDataIfExist() {
        Category mockCategory = new Category();
        mockCategory.setName("Fruits");
        Optional<Category> optionalCategory = Optional.of(mockCategory);
        when(categoryRepository.findByName("Fruits")).thenReturn(optionalCategory);

        Category category = categoryService.findByName("Fruits");

        assertEquals(category.getName(), "Fruits");
    }

    @Test
    void findByNameThrowsExceptionIfNotExists() {
        Optional<Category> optionalCategory = Optional.empty();
        when(categoryRepository.findByName("Fruits")).thenReturn(optionalCategory);

        FSNotFoundException exception = assertThrows(FSNotFoundException.class, () -> categoryService.findByName("Fruits"));

        assertEquals("Category with name: Fruits not found", exception.getMessage());
    }
}