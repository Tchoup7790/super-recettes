package com.group.SuperRecipes.model.Ingredient ;

import com.group.SuperRecipes.model.dao.Ingredient;
import com.group.SuperRecipes.model.dto.IngredientCreateInput;
import com.group.SuperRecipes.exception.ApiException;
import com.group.SuperRecipes.repository.IngredientRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }

    public Category getIngredientById(String id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Ingredient not found"
        ));
    }

    public Category createIngredient(IngredientCreateInput input) {
        Ingredient newCategory = Ingredient.builder()
                .name(input.name())
                .build();

        return ingredientRepository.save(newCategory);
    }

    public Ingredient updateIngredient(String id, IngredientCreateInput input) {
        Ingredient category = ingredientRepository.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Ingredient not found"
        ));

        ingredient.setName(input.name());

        return ingredientRepository.save(category);
    }

}