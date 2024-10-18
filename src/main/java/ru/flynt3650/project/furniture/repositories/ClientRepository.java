package ru.flynt3650.project.furniture.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.flynt3650.project.furniture.models.Client;

import java.util.List;

@Repository
public class ClientRepository implements IMyCrudRepository<Client, Integer> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Client client) {
        String sql = "INSERT INTO client(first_name, last_name, email, phone_number, address) VALUES (?, ?, ?, ?, ?)";
        System.out.println(client);
        jdbcTemplate.update(sql,
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhoneNumber(),
                client.getAddress());
    }

    @Override
    public List<Client> readAll() {
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public Client readOne(Integer id) {
        String sql = "SELECT * FROM client WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Client.class), id);
    }

    @Override
    public void update(Integer id, Client client) {
        String sql = "UPDATE client SET first_name=?, last_name=?, email=?, phone_number=?, address=? WHERE id=?";
        jdbcTemplate.update(sql,
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhoneNumber(),
                client.getAddress(),
                id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM client where id=?";
        jdbcTemplate.update(sql, id);
    }
}
