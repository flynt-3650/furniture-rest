package ru.flynt3650.project.furniture.mappers;


import org.springframework.jdbc.core.RowMapper;
import ru.flynt3650.project.furniture.models.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt("id"));
        client.setFirstName(rs.getString("first_name"));
        client.setLastName(rs.getString("last_name"));
        client.setEmail(rs.getString("email"));
        client.setPhoneNumber(rs.getString("phone_number"));
        client.setAddress(rs.getString("address"));
        return client;
    }
}
