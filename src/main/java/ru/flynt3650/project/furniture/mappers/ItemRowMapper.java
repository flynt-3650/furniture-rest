package ru.flynt3650.project.furniture.mappers;

import ru.flynt3650.project.furniture.models.Item;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setItemName(rs.getString("item_name"));
        item.setPrice(rs.getDouble("price"));
        item.setCategoryId(rs.getInt("category_id"));
        return item;
    }
}
