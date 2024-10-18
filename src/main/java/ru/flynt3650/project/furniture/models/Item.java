package ru.flynt3650.project.furniture.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Item {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 3, max = 100, message = "name must be between 3 and 100")
    private String itemName;

    @NotNull
    @Min(value = 0, message = "price must be more than 0")
    private Double price;

    private Category category;

    public Item() {
    }

    public Item(Integer id, String itemName, Double price, Category category) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
