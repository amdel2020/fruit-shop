package com.amit.fruitshop.controllers;

import com.amit.fruitshop.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class CategoryControllerTest {

    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryService = Mockito.mock(CategoryService.class);
        categoryController = new CategoryController(categoryService);
    }

    @Test
    void getCategories() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).findAll();

    }
}