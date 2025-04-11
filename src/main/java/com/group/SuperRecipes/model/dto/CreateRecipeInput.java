package com.group.SuperRecipes.model.dto;

import java.util.List;
import java.util.Set;

public record CreateRecipeInput(
        String title,
        Integer preparationTime,
        String categoryId,
        Set<String> ingredientIds,
        List<CreateStepInput> steps) {
}
