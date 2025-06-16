package com.group.SuperRecipes.controller;

import com.group.SuperRecipes.model.dao.Category;
import com.group.SuperRecipes.model.dao.Recipe;
import com.group.SuperRecipes.model.dto.CreateCategoryInput;
import com.group.SuperRecipes.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping("/recipes")
    public List<Recipe> getRecipesByCategory(@RequestParam String name) {
        return service.getAllRecipesByCategory(name);
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
