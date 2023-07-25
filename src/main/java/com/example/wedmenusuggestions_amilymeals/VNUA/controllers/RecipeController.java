package com.example.wedmenusuggestions_amilymeals.VNUA.controllers;


import com.example.wedmenusuggestions_amilymeals.VNUA.models.Recipe;
import com.example.wedmenusuggestions_amilymeals.VNUA.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @GetMapping("/FoodBrower")
    public String viewHomepage(Model model){
        model.addAttribute("listrecipes",recipeService.getRecipe());
        return "FoodBrowser";
    }

    @GetMapping("/showNewRecipeform")
    public String showNewRecipeForm(Model model) {
        // create model attribute to bind form data
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "new_recipe";
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
        // save recipe to database
        recipeService.saveRecipe(recipe);
        return "redirect:/FoodandRecipeBrowser";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get recipe from the service
        Recipe recipe = recipeService.getRecipeById(id);

        // set recipe as a model attribute to pre-populate the form
        model.addAttribute("recipe", recipe);
        return "update_recipe";
    }

    @GetMapping("/recipe/{id}")
    public String showDetailRecipe(@PathVariable(value = "id")long id,Model model){
        Recipe recipe = recipeService.getRecipeById(id);

        model.addAttribute("recipe",recipe);
        return "detailRecipe";
    }

    @GetMapping("/deleteRecipe/{id}")
    public String deleteRecipe(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.recipeService.deleteRecipeById(id);
        return "redirect:/FoodandRecipeBrowser";
    }
}
