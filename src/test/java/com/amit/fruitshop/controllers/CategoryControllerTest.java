package com.amit.fruitshop.controllers;

import com.amit.fruitshop.domain.Category;
import com.amit.fruitshop.exceptions.FSNotFoundException;
import com.amit.fruitshop.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @Test
    void getCategoriesReturnsOkIfDataFound() throws Exception {
        Category category = new Category();
        category.setName("Fruits");
        List<Category> categories = new ArrayList<>();
        categories.add(category);

        when(categoryService.findAll()).thenReturn(categories);

        mvc.perform(get("/categories").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(categories)));

        verify(categoryService, times(1)).findAll();

    }

    @Test
    void getCategoriesReturns404IfDataNotFound() throws Exception {
        when(categoryService.findAll()).thenThrow(FSNotFoundException.class);

        mvc.perform(get("/categories").contentType("application/json"))
                .andExpect(status().isNotFound());

        verify(categoryService, times(1)).findAll();

    }

    @Test
    void getCategoryReturnsOkIfDataFound() throws Exception {
        Category category = new Category();
        category.setName("Fruits");

        when(categoryService.findByName("Fruits")).thenReturn(category);

        mvc.perform(get("/categories/Fruits").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(category)));

        verify(categoryService, times(1)).findByName("Fruits");
    }

    @Test
    void getCategoryReturns404IfDataNotFound() throws Exception {

        when(categoryService.findByName("Fruits")).thenThrow(FSNotFoundException.class);

        mvc.perform(get("/categories/Fruits").contentType("application/json"))
                .andExpect(status().isNotFound());

        verify(categoryService, times(1)).findByName("Fruits");
    }
}