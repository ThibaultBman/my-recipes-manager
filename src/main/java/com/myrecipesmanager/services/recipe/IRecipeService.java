package com.myrecipesmanager.services.recipe;

import com.myrecipesmanager.dtos.RecipeDTO;
import com.myrecipesmanager.models.Recipe;

import java.util.List;

public interface IRecipeService {

    Long getRecipesCount();

    /**
     * Get all recipes from database
     * @return list of recipes
     */
    List<Recipe> getAllRecipes();

    /**
     * Add a recipe in the database
     * @param recipeDTO Recipe to save
     * @return Saved entity
     */
    Recipe addRecipe(RecipeDTO recipeDTO);

    /**
     * Get a recipe by id
     * @param id Recipe's id
     * @return Recipe
     */
    Recipe getRecipeById(Integer id);

    /**
     * Update a recipe
     * @param id Recipe's id
     * @param recipeDTO Recipe's update
     * @return Updated recipe
     */
    Recipe updateRecipe(Integer id, RecipeDTO recipeDTO);

    /**
     * Delete a recipe
     * @param id Recipe's id
     */
    void deleteRecipe(Integer id);
}
