package com.group.SuperCategories.service;

import com.group.SuperCategories.exception.ApiException;
import com.group.SuperCategories.model.dao.Category;
import com.group.SuperCategories.model.dto.CreateCategoryInput;
import com.group.SuperCategories.repository.CategoryRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> findAll() {
        return repo.findAll();
    }

    public Category save(CreateCategoryInput input) {
        Category newCategory = Category.builder()
                .name(input.name())
                .build();

        return repo.save(newCategory);
    }

    public Category findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Category not found"));
    }

    public Category update(String id, CreateCategoryInput input) {
        Category category = repo.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Category not found"));

        category.setName(input.name());

        return repo.save(category);
    }

    public void delete(String id) {
        Category category = repo.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Category not found"));

        repo.delete(category);
    }
}