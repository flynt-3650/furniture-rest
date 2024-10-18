package ru.flynt3650.project.furniture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.flynt3650.project.furniture.models.Client;
import ru.flynt3650.project.furniture.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client) {
        clientRepository.create(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.readAll();
    }

    public Client getClientById(Integer id) {
        return clientRepository.readOne(id);
    }

    public void updateClient(Integer id, Client client) {
        clientRepository.update(id, client);
    }

    public void deleteClient(Integer id) {
        clientRepository.delete(id);
    }
}
