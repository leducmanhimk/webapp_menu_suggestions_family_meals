package com.example.wedmenusuggestions_amilymeals.VNUA.controllers;


import com.example.wedmenusuggestions_amilymeals.VNUA.models.FileUploadUtil;
import com.example.wedmenusuggestions_amilymeals.VNUA.models.Recipe;
import com.example.wedmenusuggestions_amilymeals.VNUA.services.RecipeService;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;



    @GetMapping("/FoodBrower")
    public String viewHomepage(Model model){
        model.addAttribute("listrecipes",recipeService.getRecipe());
        return "FoodBrowser";
    }

    @GetMapping("/newrecipe")
    public String showNewRecipeForm(Model model){

        // create model attribute to bind form data
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "form_save_recipe";
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(@RequestParam("imagefile")MultipartFile multipartFile,@ModelAttribute("recipe") Recipe recipe) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        System.out.println(filename);
        recipe.setImage(filename);
        String uploadDir = System.getProperty("user.dir") + "//static/img";
        FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
        // save recipe to database
        recipeService.saveRecipe(recipe);
        return "redirect:/FoodBrower";
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
        return "redirect:/FoodBrower";
    }
}
