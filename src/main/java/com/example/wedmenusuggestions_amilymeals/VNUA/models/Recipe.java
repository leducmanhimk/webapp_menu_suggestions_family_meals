package com.example.wedmenusuggestions_amilymeals.VNUA.models;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "title",length = 100)
    private String title;

    @Column(name = "cooktime")
    private int cooktime;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "categories",length = 20)
    private String categories;

    public Recipe(Long id, String title, int cooktime, String description, String image, String categories) {
        Id = id;
        this.title = title;
        this.cooktime = cooktime;
        this.description = description;
        this.image = image;
        this.categories = categories;
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
}
