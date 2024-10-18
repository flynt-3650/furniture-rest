package ru.flynt3650.project.furniture.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.flynt3650.project.furniture.mappers.ItemRowMapper;
import ru.flynt3650.project.furniture.models.Item;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository implements IMyCrudRepository<Item, Integer> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepository(JdbcTemplate jdbcTemplate) {
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
    public Optional<Item> readOne(Integer id) {
        String sql = "SELECT * FROM item WHERE id=?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new ItemRowMapper(), id));
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
