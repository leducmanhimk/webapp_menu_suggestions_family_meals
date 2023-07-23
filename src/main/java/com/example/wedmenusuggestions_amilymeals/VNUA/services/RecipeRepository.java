package com.example.wedmenusuggestions_amilymeals.VNUA.services;

import com.example.wedmenusuggestions_amilymeals.VNUA.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository  extends JpaRepository<Recipe, Long> {

}
