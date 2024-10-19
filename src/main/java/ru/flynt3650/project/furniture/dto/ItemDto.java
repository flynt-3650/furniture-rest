package ru.flynt3650.project.furniture.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class ItemDto {

    @NotNull
    private Integer id;

    @NotNull
    @Size(message = "name must be between 3 and 100", min = 3, max = 100)
    private String itemName;

    @NotNull
    @Min(message = "price must be more than 0", value = 0)
    private Double price;

    private Integer categoryId;

    public ItemDto() {
    }

    public ItemDto(Integer id, String itemName, Double price, Integer categoryId) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto entity = (ItemDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.itemName, entity.itemName) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.categoryId, entity.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, price, categoryId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "itemName = " + itemName + ", " +
                "price = " + price + ", " +
                "category = " + categoryId + ")";
    }
}