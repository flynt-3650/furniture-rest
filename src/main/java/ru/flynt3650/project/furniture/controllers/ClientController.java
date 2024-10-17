package ru.flynt3650.project.furniture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public void postClient(@RequestBody Client client) {
        clientDao.create(client);
    }

    @GetMapping()
    public List<Client> getAllClients() {
        return clientDao.readAll();
    }

    @GetMapping("/{id}")
    public Client getOneClient(@PathVariable("id") int id) {
        return clientDao.readById(id);
    }

    @PostMapping("/update")
    public void updateOneClient(@RequestBody Client client) {
        clientDao.updateClient(client);
    }

    @PostMapping("/delete/{id}")
    public void deleteOneClient(@PathVariable("id") int id) {
        clientDao.deleteClient(id);
    }
}
