package ru.flynt3650.project.furniture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.flynt3650.project.furniture.services.ItemService;
import ru.flynt3650.project.furniture.models.Item;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public void postItem(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @GetMapping()
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getOneItem(@PathVariable("id") Integer id) {
        return itemService.getItemById(id);
    }

    @PatchMapping("/update/{id}")
    public void patchOneItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        itemService.updateItem(id, item);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneItem(@PathVariable("id") Integer id) {
        itemService.deleteItem(id);
    }
}
