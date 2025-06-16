package com.group.SuperRecipes.service;

import com.group.SuperRecipes.exception.ApiException;
import com.group.SuperRecipes.model.dao.Recipe;
import com.group.SuperRecipes.model.dao.Step;
import com.group.SuperRecipes.model.dto.CreateStepInput;
import com.group.SuperRecipes.model.dto.UpdateStepInput;
import com.group.SuperRecipes.repository.RecipeRepository;
import com.group.SuperRecipes.repository.StepRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {

    private final StepRepository stepRepository;
    private final RecipeRepository recipeRepository;

    public StepService(StepRepository stepRepository, RecipeRepository recipeRepository) {
        this.stepRepository = stepRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<Step> findAll() {
        return stepRepository.findAll();
    }

    public Step findById(String id) {
        return stepRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Step not found"));
    }

    public Step save(CreateStepInput input) {
        Recipe recipe = recipeRepository.findById(input.recipeId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Recipe not found"));

        Step step = Step.builder()
                .stepOrder(input.stepOrder())
                .description(input.description())
                .recipe(recipe)
                .build();

        return stepRepository.save(step);
    }

    public Step update(String id, UpdateStepInput input) {
        Step step = findById(id);

        if (input.stepOrder() != null)
            step.setStepOrder(input.stepOrder());
        if (input.description() != null)
            step.setDescription(input.description());

        return stepRepository.save(step);
    }

    public void delete(String id) {
        Step step = findById(id);
        stepRepository.delete(step);
    }
}