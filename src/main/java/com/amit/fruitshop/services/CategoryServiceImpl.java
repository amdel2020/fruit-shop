package com.amit.fruitshop.services;

import com.amit.fruitshop.domain.Category;
import com.amit.fruitshop.exceptions.FSNotFoundException;
import com.amit.fruitshop.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();

        if (categories.size() == 0) throw new FSNotFoundException("No categories found");

        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String name) {

        Optional<Category> category = categoryRepository.findByName(name);

        if (category.isEmpty())
            throw new FSNotFoundException("Category with name: " + name + " not found");

        return category.get();
    }
}
