package com.akhazov.project.client.service;

import com.akhazov.project.client.repository.ClientRepository;
import com.akhazov.project.client.repository.entity.Client;
import com.akhazov.project.client.repository.entity.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис поиска клиетов в БД по параметрам
 */

@Service
public class FindAndAddClientService implements ClientService {

    private final ClientRepository repository;

    public FindAndAddClientService(ClientRepository repository) {
        this.repository = repository;
    }

    /**
     * Поиск клиента по идентификатору
     *
     * @param id идентификатор
     * @return найденный клиент
     */
    @Override
    public String getClientNameById(String id) {
        Client client = repository.getClientById ( id );
        return client.getName ();
    }

    /**
     * Поиск клиента по Фамилии
     *
     * @param lastName идентификатор
     * @return найденный клиент
     */
    @Override
    public String getIdByLastName(String lastName) {
        Client client = repository.getIDByLastName ( lastName );
        return client.getId ();
    }

    /**
     * Метод ищет всех клиентов БД
     *
     * @return список клиентов в формате Имя, Фамилия
     */
    @Override
    public List<ClientDTO> getAllClient() {
        List<Client> allClient = repository.getAllClient ();
        List<ClientDTO> dtoClient = new ArrayList<> ();
        for (Client client : allClient) {
            dtoClient.add ( mapToClientDTO ( client ) );
        }
        return dtoClient;
    }

    /**
     * Добавление нового клиента в БД
     * @param name Имя клиента
     * @param lastName Фамилия клиента
     */
    @Override
    public void newClient(String name, String lastName) {
        repository.save (new Client (name,lastName));
    }

    /**
     * Метод преобразует сущность в формат Имя, Фамилия
     *
     * @param client сущность БД
     * @return новая сущность
     */
    public ClientDTO mapToClientDTO(Client client) {
        ClientDTO dto = new ClientDTO ();
        dto.setName ( client.getName () );
        dto.setLastName ( client.getLastName () );
        return dto;
    }

}
