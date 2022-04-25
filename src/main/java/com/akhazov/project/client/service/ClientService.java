package com.akhazov.project.client.service;

import com.akhazov.project.client.model.dto.ClientDTO;

import java.util.List;

/**
 * Сервис работы с клиентом.
 */
public interface ClientService {

    /**
     * Возвращает имя клиента по идентификатору.
     *
     * @param id идентификатор
     * @return Имя клиента
     */
    String getClientNameById(Long id);

    /**
     * Возвращает id клиента по Фамилии.
     *
     * @param lastName идентификатор
     * @return id клиента
     */
    Long getIdByLastName(String lastName);

    /**
     * Возвращает всех клиентов.
     *
     * @return List клиентов
     */
    List<ClientDTO> getAllClient();

    /**
     * Добавление нового клиента в БД
     *
     * @param client Клиент
     * @return Id клиента
     */
    String newClient(ClientDTO client);
}
