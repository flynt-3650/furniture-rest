package ru.flynt3650.project.furniture.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.flynt3650.project.furniture.dto.ClientDto;
import ru.flynt3650.project.furniture.services.ClientService;
import ru.flynt3650.project.furniture.models.Client;
import ru.flynt3650.project.furniture.util.ClientNotAddedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    private final ModelMapper modelMapper;

    @Autowired
    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public void postClient(@RequestBody @Valid ClientDto clientDto,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors)
                errorMessage
                        .append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");

            throw new ClientNotAddedException(errorMessage.toString());
        }

        clientService.createClient(toClient(clientDto));
    }

    @GetMapping()
    public List<ClientDto> getAllClients() {
        return clientService
                .getAllClients()
                .stream()
                .map(this::toClientDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientDto getOneClient(@PathVariable("id") Integer id) {


        return toClientDto(clientService.getClientById(id));
    }

    @PatchMapping("/update/{id}")
    public void patchOneClient(@PathVariable("id") Integer id, @RequestBody @Valid ClientDto clientDto,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors)
                errorMessage
                        .append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");

            throw new ClientNotAddedException(errorMessage.toString());
        }

        clientService.updateClient(id, toClient(clientDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/clientOrder")
    public List<Map<String, Object>> getClientOrder() {
        return clientService.getClientOrderInfo();
    }

    private Client toClient(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    private ClientDto toClientDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }
}
