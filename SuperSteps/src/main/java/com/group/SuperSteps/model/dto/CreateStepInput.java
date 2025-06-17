package com.group.SuperSteps.model.dto;

public record CreateStepInput(
        String description,
        Integer stepOrder,
        String recipeId) {
}
