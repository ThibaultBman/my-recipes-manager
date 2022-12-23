package com.myrecipesmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@Getter
@Setter
@Validated
public class Recipe {

    @Id
    @SequenceGenerator(
            name = "recipe_id_sequence",
            sequenceName = "recipe_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_id_sequence"
    )
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer prepTime;
    @NotNull
    private Integer cookTime;
    @NotNull
    private Integer servings;
    // Ingredients
    // Directions
}
