package com.example.wedmenusuggestions_amilymeals.VNUA.controllers;


import com.example.wedmenusuggestions_amilymeals.VNUA.models.FileUploadUtil;
import com.example.wedmenusuggestions_amilymeals.VNUA.models.Recipe;
import com.example.wedmenusuggestions_amilymeals.VNUA.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    @GetMapping("recipe/foodbrower")
    public String viewHomepage(Model model){
        model.addAttribute("listrecipes",recipeService.getRecipe());
        return "foodBrowser";
    }

    @GetMapping("recipe/saverecipe")
    public String showNewRecipeForm(Model model){
        // create model attribute to bind form data
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "form_save_recipe";
    }

    @PostMapping("recipe/saverecipe")
    public String saveRecipe(@RequestParam(value = "imagefile",required = false)MultipartFile multipartFile ,@Valid @ModelAttribute("recipe")
      Recipe recipe, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "form_save_recipe";
        }
        saveOrUpdateRecipe(recipe,multipartFile);
        return "redirect:/recipe/foodbrower";
    }
    public void saveOrUpdateRecipe(Recipe recipe, MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        if (filename.equals("")) {
            recipeService.saveRecipe(recipe);
        }
        else {
            recipe.setImage(filename);
            String uploadDir = System.getProperty("user.dir") + "//static/img";
            FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
            recipeService.saveRecipe(recipe);

        }

        // save recipe to database
        recipeService.saveRecipe(recipe);
    }
    @PostMapping("recipe/update")
    public String updateRecipe(@RequestParam(value = "imagefile",required = false)MultipartFile multipartFile ,@Valid @ModelAttribute("recipe")
                                   Recipe recipe, BindingResult result) throws IOException {
        recipeService.getRecipeById(recipe.getId());
        saveOrUpdateRecipe(recipe,multipartFile);

        recipeService.saveRecipe(recipe);
        return "redirect:/recipe/foodbrower";
    }

    @GetMapping("recipe/updaterecipe/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get recipe from the service
        Recipe recipe = recipeService.getRecipeById(id);

        // set recipe as a model attribute to pre-populate the form
        model.addAttribute("recipe", recipe);
        return "update_recipe_form";
    }

    @GetMapping("/recipe/detail/{id}")
    public String showDetailRecipe(@PathVariable(value = "id")long id,Model model){
        Recipe recipe = recipeService.getRecipeById(id);

        model.addAttribute("recipe",recipe);
        return "detailRecipe";
    }

    @GetMapping("/deleteRecipe/{id}")
    public String deleteRecipe(@PathVariable(value = "id") long id) {
        // call delete employee method
        this.recipeService.deleteRecipeById(id);
        return "redirect:/recipe/foodbrower";
    }
}
