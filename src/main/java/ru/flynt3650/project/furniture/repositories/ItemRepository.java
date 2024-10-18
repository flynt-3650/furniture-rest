package ru.flynt3650.project.furniture.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.flynt3650.project.furniture.models.Item;

import java.util.List;
import java.util.Optional;

public class ItemRepository implements IMyCrudRepository<Item, Integer> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Item item) {

    }

    @Override
    public List<Item> readAll() {
        return List.of();
    }

    @Override
    public Optional<Item> readOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer integer, Item item) {

    }

    @Override
    public void delete(Integer id) {

    }
}
