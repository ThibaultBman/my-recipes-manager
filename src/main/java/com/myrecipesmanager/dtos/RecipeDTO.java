package com.myrecipesmanager.dtos;

public record RecipeDTO (

    String name,
    Integer prepTime,
    Integer cookTime,
    Integer servings
) { }

