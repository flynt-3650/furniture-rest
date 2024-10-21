package ru.flynt3650.project.furniture.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.flynt3650.project.furniture.dao.ItemDao;
import ru.flynt3650.project.furniture.dto.ItemDto;
import ru.flynt3650.project.furniture.models.Item;
import ru.flynt3650.project.furniture.util.exceptions.ClientNotPostedException;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemDao itemDao;

    private final ModelMapper modelMapper;

    @Autowired
    public ItemController(ItemDao itemDao, ModelMapper modelMapper) {
        this.itemDao = itemDao;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public void postItem(@RequestBody @Valid ItemDto itemDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors)
                errorMessage
                        .append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");

            throw new ClientNotPostedException(errorMessage.toString());
        }

        itemDao.create(toItem(itemDto));
    }

    @GetMapping()
    public List<ItemDto> getAllItems() {
        return itemDao
                .readAll()
                .stream()
                .map(this::toItemDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ItemDto getOneItem(@PathVariable("id") Integer id) {
        return toItemDto(itemDao.readOne(id));
    }

    @PatchMapping("/update/{id}")
    public void patchOneItem(@PathVariable("id") Integer id, @RequestBody @Valid ItemDto itemDto,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors)
                errorMessage
                        .append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");

            throw new ClientNotPostedException(errorMessage.toString());
        }

        itemDao.update(id, toItem(itemDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneItem(@PathVariable("id") Integer id) {
        itemDao.delete(id);
    }

    private ItemDto toItemDto(Item item) {
        return modelMapper.map(item, ItemDto.class);
    }

    private Item toItem(ItemDto itemDto) {
        return modelMapper.map(itemDto, Item.class);
    }
}
