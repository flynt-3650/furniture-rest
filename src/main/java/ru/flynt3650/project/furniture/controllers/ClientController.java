package ru.flynt3650.project.furniture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flynt3650.project.furniture.dao.ClientDao;
import ru.flynt3650.project.furniture.models.Client;

import java.util.List;

@RestController
@RequestMapping()
public class ClientController {

    private final ClientDao clientDao;

    @Autowired
    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping()
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    @GetMapping("/{id}")
    public Client getOneClient(@PathVariable("id") int id) {
        return clientDao.findById(id);
    }
}
