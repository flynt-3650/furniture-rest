package ru.flynt3650.project.furniture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.flynt3650.project.furniture.services.ClientService;
import ru.flynt3650.project.furniture.models.Client;

import java.util.List;

@RestController
@RequestMapping()
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public void postClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @GetMapping()
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getOneClient(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }

    @PatchMapping("/update/{id}")
    public void updateOneClient(@PathVariable("id") Integer id, @RequestBody Client client) {
        clientService.updateClient(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneClient(@PathVariable("id") int id) {
        clientService.deleteClient(id);
    }
}
