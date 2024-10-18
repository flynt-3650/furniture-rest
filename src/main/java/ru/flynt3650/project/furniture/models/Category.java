package ru.flynt3650.project.furniture.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Category {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "name must be between 3 and 50")
    private String categoryName;

    public Category() {
    }

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
