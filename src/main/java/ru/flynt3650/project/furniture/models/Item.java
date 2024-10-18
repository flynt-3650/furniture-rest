package ru.flynt3650.project.furniture.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class Item implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 3, max = 100, message = "name must be between 3 and 100")
    private String itemName;

    @NotNull
    @Min(value = 0, message = "price must be more than 0")
    private Double price;

    private Integer categoryId;

    public Item() {
    }

    public Item(int id, String itemName, Double price, Integer categoryId) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
