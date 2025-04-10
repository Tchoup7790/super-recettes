package com.group.SuperRecipes.repository;

import com.group.SuperRecipes.repository.IngredientRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientRepository, String> {
    Optional<IngredientRepository> findByName(String name);
}