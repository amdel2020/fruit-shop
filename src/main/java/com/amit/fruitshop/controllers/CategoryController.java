package com.amit.fruitshop.controllers;

import com.amit.fruitshop.domain.Category;
import com.amit.fruitshop.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<Category> getCategory(@PathVariable String name) {
        Category category = categoryService.findByName(name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
