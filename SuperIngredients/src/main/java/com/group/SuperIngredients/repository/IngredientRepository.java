package com.group.SuperIngredients.repository;

import com.group.SuperIngredients.model.dao.Ingredient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
    Optional<IngredientRepository> findByName(String name);
}