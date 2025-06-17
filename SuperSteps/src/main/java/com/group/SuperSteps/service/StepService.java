package com.group.SuperSteps.service;

import com.group.SuperSteps.exception.ApiException;
import com.group.SuperSteps.model.dao.Recipe;
import com.group.SuperSteps.model.dao.Step;
import com.group.SuperSteps.model.dto.CreateStepInput;
import com.group.SuperSteps.model.dto.UpdateStepInput;
import com.group.SuperSteps.repository.StepRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {

    private final StepRepository stepRepository;
    private final RecipeService recipeService;

    public StepService(StepRepository stepRepository, RecipeService recipeService) {
        this.stepRepository = stepRepository;
        this.recipeService = recipeService;
    }

    public List<Step> findAll() {
        return stepRepository.findAll();
    }

    public Step findById(String id) {
        return stepRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Step not found"));
    }

    public Step save(CreateStepInput input) {
        Recipe recipe = recipeService.findById(input.recipeId());

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