package com.example.wedmenusuggestions_amilymeals.VNUA.services;

import com.example.wedmenusuggestions_amilymeals.VNUA.models.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipe();
    void saveRecipe(Recipe recipe);

    Recipe getRecipeById(long id);
    void deleteRecipeById(long id);


}
