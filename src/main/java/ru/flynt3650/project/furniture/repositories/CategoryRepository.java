package ru.flynt3650.project.furniture.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.flynt3650.project.furniture.models.Category;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements IMyCrudRepository<Category, Integer> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Category category) {

    }

    @Override
    public List<Category> readAll() {
        return List.of();
    }

    @Override
    public Optional<Category> readOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer integer, Category category) {

    }

    @Override
    public void delete(Integer id) {

    }
}
