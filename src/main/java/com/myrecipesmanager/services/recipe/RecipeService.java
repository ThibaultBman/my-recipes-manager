package com.myrecipesmanager.services.recipe;

import com.myrecipesmanager.dtos.RecipeDTO;
import com.myrecipesmanager.models.Recipe;
import com.myrecipesmanager.repositories.RecipeRepository;
import com.myrecipesmanager.transformers.RecipeTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeTransformer recipeTransformer;

    public Long getRecipesCount() {
        return recipeRepository.count();
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Integer id) {
        return recipeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No recipe found"));
    }

    public Recipe addRecipe(RecipeDTO recipeDTO) {
        return recipeRepository.save(recipeTransformer.transform(recipeDTO, new Recipe()));
    }

    public Recipe updateRecipe(Integer id, RecipeDTO recipeDTO) {
        if (!recipeRepository.existsById(id)) {
            throw new EntityNotFoundException("The recipe doesn't exist");
        }

        return recipeRepository.save(recipeTransformer.transform(recipeDTO, new Recipe()));
    }

    public void deleteRecipe(Integer id) {
        Recipe recipe = getRecipeById(id);
        recipeRepository.delete(recipe);
    }
}
