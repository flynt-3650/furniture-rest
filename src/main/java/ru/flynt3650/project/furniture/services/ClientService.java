package ru.flynt3650.project.furniture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.flynt3650.project.furniture.models.Client;
import ru.flynt3650.project.furniture.repositories.ClientRepository;

import java.util.List;
import java.util.Map;

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
        return clientRepository.readOne(id).orElse(null);
    }

    public void updateClient(Integer id, Client client) {
        clientRepository.update(id, client);
    }

    public void deleteClient(Integer id) {
        clientRepository.delete(id);
    }

    public List<Map<String, Object>> getClientOrderInfo() {
        return clientRepository.getClientOrderInfo();
    }
}
