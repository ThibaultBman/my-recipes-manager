package com.myrecipesmanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    private String name;
    private Integer duration;
}
