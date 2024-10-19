package ru.flynt3650.project.furniture.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.flynt3650.project.furniture.dto.ItemDto;
import ru.flynt3650.project.furniture.models.Item;
import ru.flynt3650.project.furniture.services.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    private final ModelMapper modelMapper;

    @Autowired
    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public void postItem(@RequestBody ItemDto itemDto) {
        itemService.createItem(toItem(itemDto));
    }

    @GetMapping()
    public List<ItemDto> getAllItems() {
        return itemService
                .getAllItems()
                .stream()
                .map(this::toItemDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ItemDto getOneItem(@PathVariable("id") Integer id) {
        return toItemDto(itemService.getItemById(id));
    }

    @PatchMapping("/update/{id}")
    public void patchOneItem(@PathVariable("id") Integer id, @RequestBody ItemDto itemDto) {
        itemService.updateItem(id, toItem(itemDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneItem(@PathVariable("id") Integer id) {
        itemService.deleteItem(id);
    }

    private ItemDto toItemDto(Item item) {
        return modelMapper.map(item, ItemDto.class);
    }

    private Item toItem(ItemDto itemDto) {
        return modelMapper.map(itemDto, Item.class);
    }
}
