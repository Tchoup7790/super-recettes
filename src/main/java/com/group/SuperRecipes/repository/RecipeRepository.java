package com.group.SuperRecipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.SuperRecipes.model.dao.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, String> {
}
