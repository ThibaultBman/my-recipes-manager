package com.myrecipesmanager.controllers;

import com.myrecipesmanager.dtos.RecipeDTO;
import com.myrecipesmanager.models.Recipe;
import com.myrecipesmanager.services.recipe.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Integer id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody RecipeDTO recipeDTO) {
        return recipeService.addRecipe(recipeDTO);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Integer id, @RequestBody RecipeDTO recipeDTO) { return recipeService.updateRecipe(id, recipeDTO);}

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeService.deleteRecipe(id);
    }
}
