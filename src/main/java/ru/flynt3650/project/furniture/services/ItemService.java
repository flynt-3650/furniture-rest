package ru.flynt3650.project.furniture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.flynt3650.project.furniture.models.Item;
import ru.flynt3650.project.furniture.dao.ItemDao;

import java.util.List;

@Service
public class ItemService {

    private final ItemDao itemRepository;

    @Autowired
    public ItemService(ItemDao itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(Item item) {
        itemRepository.create(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.readAll();
    }

    public Item getItemById(Integer id) {
        return itemRepository.readOne(id);
    }

    public void updateItem(Integer id, Item item) {
        itemRepository.update(id, item);
    }

    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }
}
