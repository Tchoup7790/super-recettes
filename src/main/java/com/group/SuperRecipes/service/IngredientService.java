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


}