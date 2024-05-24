package com.bookAdoption.adoptabook.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookAdoption.adoptabook.entity.Category;
import com.bookAdoption.adoptabook.repository.CategoryInterface;

@Service
public class CategoryService {

    @Autowired
    private CategoryInterface categoryInterface;

    public List<Category> getAllCategories() {
        return categoryInterface.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryInterface.findById(id);
    }

    public List<Category> getCategoriesByName(String name) {
        Optional<List<Category>> cathegories = categoryInterface.findByNameContainingIgnoreCase(name);
        if (cathegories.isPresent()) {
            return cathegories.get();
        } else {
            return Collections.emptyList();
        }
    }

    public Category saveCategory(Category category) {
        return categoryInterface.save(category);
    }

    public Category updateCategoryById(Long id, Category newCategoryData) {
        Optional<Category> categoryData = categoryInterface.findById(id);
        if (categoryData.isPresent()) {
            Category updatedCategoryData = categoryData.get();
            updatedCategoryData.setName(newCategoryData.getName());
            if (newCategoryData.getBooks() != null) {
                updatedCategoryData.setBooks(newCategoryData.getBooks());
            }
            return categoryInterface.save(updatedCategoryData);
        } else {
            return null;
        }
    }

    public void deleteCategoryById(Long id) {
        categoryInterface.deleteById(id);
    }

}
