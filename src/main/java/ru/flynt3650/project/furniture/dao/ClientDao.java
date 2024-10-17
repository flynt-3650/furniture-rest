package ru.flynt3650.project.furniture.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.flynt3650.project.furniture.models.Client;

import java.util.List;

@Component
public class ClientDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create
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

    // Read
    public List<Client> readAll() {
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    public Client readById(int id) {
        String sql = "SELECT * FROM client WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Client.class), id);
    }

    // Update
    public void updateClient(Client client) {
        String sql = "UPDATE client SET first_name=?, last_name=?, email=?, phone_number=?, address=? WHERE id=?";
        jdbcTemplate.update(sql,
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhoneNumber(),
                client.getAddress(),
                client.getId());
    }
}
