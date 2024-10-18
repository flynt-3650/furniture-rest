package ru.flynt3650.project.furniture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.flynt3650.project.furniture.services.ClientService;
import ru.flynt3650.project.furniture.models.Client;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
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
    public Client getOneClient(@PathVariable("id") Integer id) {
        return clientService.getClientById(id);
    }

    @PatchMapping("/update/{id}")
    public void patchOneClient(@PathVariable("id") Integer id, @RequestBody Client client) {
        clientService.updateClient(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/clientOrder")
    public List<Map<String, Object>> getClientOrder() {
        return clientService.getClientOrderInfo();
    }
}
