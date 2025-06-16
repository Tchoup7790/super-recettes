package com.group.SuperRecipes.service;

import com.group.SuperRecipes.exception.ApiException;
import com.group.SuperRecipes.model.dao.Category;
import com.group.SuperRecipes.model.dao.Recipe;
import com.group.SuperRecipes.model.dto.CreateCategoryInput;
import com.group.SuperRecipes.repository.CategoryRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository repo;


    private final WebClient webClient = WebClient.create();

    public List<Recipe> getAllRecipesByCategory(String category) {
        String url = "http://localhost:8084/api/v1/recipes";

        List<Recipe> recipes = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Recipe.class)
                .collectList()
                .block();

        return recipes.stream()
                .filter(r -> r.getCategory() != null && category.equalsIgnoreCase(r.getCategory().getName()))
                .collect(Collectors.toList());
    }



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
