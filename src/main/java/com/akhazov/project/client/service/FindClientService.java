package com.akhazov.project.client.service;

import com.akhazov.project.client.repository.ClientRepository;
import com.akhazov.project.client.repository.entity.Client;
import com.akhazov.project.client.repository.entity.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindClientService implements ClientService {

    private final ClientRepository repository;

    public FindClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getClientNameById(String id) {
        Client client = repository.getClientById(id);
        return client.getName();
    }

    @Override
    public String getIdByLastName(String lastName) {
        Client client = repository.getIDByLastName(lastName);
        return  client.getId();
    }

    @Override
    public List<ClientDTO> getAllClient() {
        List<Client> allClient = repository.getAllClient();
        List<ClientDTO> dtoClient = new ArrayList<>();
        for (Client client : allClient) {
            dtoClient.add(mapToClientDTO(client));
        }
        return dtoClient;
    }


    public ClientDTO mapToClientDTO (Client client){
        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setLastName(client.getLastName());
        return dto;
    }

}
