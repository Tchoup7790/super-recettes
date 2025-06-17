package com.group.SuperRecipes.model.dto;

public record CreateStepInput(
        String description,
        Integer stepOrder,
        String recipeId) {
}
