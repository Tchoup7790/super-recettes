package com.group.SuperCategories.controller;

import com.group.SuperCategories.model.dao.Category;
import com.group.SuperCategories.model.dto.CreateCategoryInput;
import com.group.SuperCategories.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> all() {
        return service.findAll();
    }

    @PostMapping
    public Category create(@RequestBody CreateCategoryInput category) {
        return service.save(category);
    }

    @GetMapping("/{id}")
    public Category one(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable String id, @RequestBody CreateCategoryInput input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}