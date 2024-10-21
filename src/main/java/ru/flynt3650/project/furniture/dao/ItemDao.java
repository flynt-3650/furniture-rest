package ru.flynt3650.project.furniture.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.flynt3650.project.furniture.mappers.ItemRowMapper;
import ru.flynt3650.project.furniture.models.Item;
import ru.flynt3650.project.furniture.util.exceptions.ItemNotFoundException;

import java.util.List;

@Repository
public class ItemDao implements MyCrudDao<Item, Integer> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Item item) {
        String sql = "INSERT INTO item(item_name, price, category_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                item.getItemName(),
                item.getPrice(),
                item.getCategoryId());
    }

    @Override
    public List<Item> readAll() {
        String sql = "SELECT * FROM item";
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    @Override
    public Item readOne(Integer id) {
        String sql = "SELECT * FROM item WHERE id=?";

        try {
            return jdbcTemplate.queryForObject(sql, new ItemRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNotFoundException("Item with id '" + id + "' was not found");
        }
    }

    @Override
    public void update(Integer id, Item item) {
        String sql = "UPDATE item SET item_name=?, price=?, category_id=? WHERE id=?";
        jdbcTemplate.update(sql,
                item.getItemName(),
                item.getPrice(),
                item.getCategoryId(),
                id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM item WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
