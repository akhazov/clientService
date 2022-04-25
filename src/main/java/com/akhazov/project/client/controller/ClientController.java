package com.akhazov.project.client.controller;

import com.akhazov.project.client.model.dto.ClientDTO;
import com.akhazov.project.client.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client/")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/name/id")
    public String getClientNameById(@RequestParam("clientId") Long id) {
        String name = clientService.getClientNameById(id);
        return "Имя клиента с ID: " + id + " " + name;
    }

    @GetMapping("/id/name")
    public Long getIdByLastName(@RequestParam("lastName") String lastName) {
        return clientService.getIdByLastName(lastName);
    }

    @GetMapping("/allClient")
    public List<ClientDTO> getAllClient() {
        return clientService.getAllClient();
    }

    @PostMapping("/new")
    public String newClient(@RequestBody ClientDTO client) {
        String idClient = clientService.newClient(client);
        return "Клиент " + idClient + " добавлен";
    }

}
