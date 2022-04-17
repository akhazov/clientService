package com.akhazov.project.client.service;

import com.akhazov.project.client.repository.entity.ClientDTO;

import java.util.List;

/**
 * Сервис работы с клиентом.
 */
public interface ClientService {

    /**
     * Возвращает имя клиента по идентификатору.
     * @param id идентификатор
     * @return Имя клиента
     */
    String getClientNameById(String id);

    String getIdByLastName(String lastName);

    List <ClientDTO> getAllClient();
}
