package com.group.SuperRecipes.service ;

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

    public Ingredient getIngredientById(String id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Ingredient not found"
        ));
    }

    public Ingredient createIngredient(IngredientCreateInput input) {
        Ingredient newIngredient = Ingredient.builder()
                .name(input.name())
                .build();

        return ingredientRepository.save(newIngredient);
    }

    public Ingredient updateIngredient(String id, IngredientCreateInput input) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Ingredient not found"
        ));

        ingredient.setName(input.name());

        return ingredientRepository.save(ingredient);
    }

}