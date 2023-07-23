package com.example.wedmenusuggestions_amilymeals.VNUA.services;

import com.example.wedmenusuggestions_amilymeals.VNUA.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;


    @Override
    public List<Recipe> getRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        this.recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipeById(long id) {
        Optional<Recipe> optional = recipeRepository.findById(id);
        Recipe recipe = null;
        if (optional.isPresent()){
            recipe = optional.get();
        }else  {
            throw new RuntimeException("Recipe not found for id::"+id);
        }
        return recipe;
    }

    @Override
    public void deleteRecipeById(long id) {
        this.recipeRepository.deleteById(id);
    }
}
