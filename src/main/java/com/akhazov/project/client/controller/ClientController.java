package com.akhazov.project.client.controller;

import com.akhazov.project.client.repository.entity.ClientDTO;
import com.akhazov.project.client.service.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.List;

@RestController
@RequestMapping("client/")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("name/id")
    public String getClientNameById(@RequestParam("clientId") String id) {
        String name = clientService.getClientNameById ( id );
        return "Имя клиента с ID: " + id + " " + name;
    }

    @GetMapping("id/name")
    public String getIdByLastName(@RequestParam("lastName") String lastName) {
        return "ID клиента по фамилии " + lastName + ": " + clientService.getIdByLastName ( lastName );
    }

    @GetMapping("allClient")
    public List<ClientDTO> getAllClient() {
        return clientService.getAllClient ();
    }

    @PostMapping("newClient")
    public String newClient(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        clientService.newClient ( name, lastName );
        return "Клиент " + lastName + " добавлен";
    }

}
