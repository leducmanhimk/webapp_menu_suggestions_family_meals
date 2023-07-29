package com.example.wedmenusuggestions_amilymeals.VNUA.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "title",length = 30,nullable = false)
    @NotBlank(message = "truường dữ liệu không được để trống")
    private String title;

    @Column(name = "cooktime")
    private int cooktime;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "categories",length = 20)
    private String categories;

    @Column(name = "preptime" ,length = 5)
    private  int preptime;

    @Column(name = "directions",columnDefinition = "TEXT")
    @Lob
    private String directions;

    @Column(name = "maindish",length = 10)
    private String maindish;

    public Recipe(Long id, String title, int cooktime, String description, String image, String categories, int preptime, String directions, String maindish) {
        Id = id;
        this.title = title;
        this.cooktime = cooktime;
        this.description = description;
        this.image = image;
        this.categories = categories;
        this.preptime = preptime;
        this.directions = directions;
        this.maindish = maindish;
    }

    public Recipe() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCooktime() {
        return cooktime;
    }

    public void setCooktime(int cooktime) {
        this.cooktime = cooktime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getMaindish() {
        return maindish;
    }

    public void setMaindish(String maindish) {
        this.maindish = maindish;
    }
}
