package com.myrecipesmanager.transformers;

import com.myrecipesmanager.dtos.RecipeDTO;
import com.myrecipesmanager.models.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeTransformer implements ITransformer<RecipeDTO, Recipe> {

    public Recipe transform(RecipeDTO inputObject, Recipe outputObject) {
        outputObject.setName(inputObject.name());
        outputObject.setPrepTime(inputObject.prepTime());
        outputObject.setCookTime(inputObject.cookTime());
        outputObject.setServings(inputObject.servings());

        return outputObject;
    }
}
