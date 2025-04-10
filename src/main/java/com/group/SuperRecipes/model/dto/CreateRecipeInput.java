package com.group.SuperRecipes.model.dto;

public record CreateRecipeInput(
        String title,
        Integer preparationTime,
        String categoryId) {
}
