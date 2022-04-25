package com.akhazov.project.client.service;

import com.akhazov.project.client.repository.ClientRepository;
import com.akhazov.project.client.repository.entity.Client;
import com.akhazov.project.client.model.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindClientService implements ClientService {

    private final ClientRepository repository;

    public FindClientService(ClientRepository repository) {
        this.repository = repository;
    }

    /**
     * Поиск клиента по идентификатору
     *
     * @param id идентификатор
     * @return найденный клиент
     */
    @Override
    public String getClientNameById(Long id) {
        Client client = repository.getClientById(id);
        return client.getName();
    }

    /**
     * Поиск клиента по Фамилии
     *
     * @param lastName идентификатор
     * @return найденный клиент
     */
    @Override
    public Long getIdByLastName(String lastName) {
        Client client = repository.getIDByLastName(lastName);
        return client.getId();
    }

    /**
     * Метод ищет всех клиентов БД
     *
     * @return список клиентов в формате Имя, Фамилия
     */
    @Override
    public List<ClientDTO> getAllClient() {
        List<Client> allClient = repository.getAllClient();
        List<ClientDTO> dtoClient = new ArrayList<>();
        for (Client client : allClient) {
            dtoClient.add(mapToClientDTO(client));
        }
        return dtoClient;
    }

    /**
     * Добавление нового клиента в БД
     *
     * @param name     Имя клиента
     * @param lastName Фамилия клиента
     * @return ID клиента в строковом представлении
     */
    @Override
    public String newClient(String name, String lastName) {
        Client client = new Client(name, lastName);
        repository.save(client);
        return "clientId\": " + client.getId() + "\"";
    }

    /**
     * Метод преобразует сущность в формат Имя, Фамилия
     *
     * @param client сущность БД
     * @return новая сущность
     */
    public ClientDTO mapToClientDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setLastName(client.getLastName());
        return dto;
    }


}
