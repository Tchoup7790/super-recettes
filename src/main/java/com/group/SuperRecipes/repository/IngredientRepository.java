package com.group.SuperRecipes.repository;

import com.group.SuperRecipes.model.dao.Ingredient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
    Optional<Ingredient> findByName(String name);
}