package com.akhazov.project.client.service;

import com.akhazov.project.client.repository.ClientRepository;
import com.akhazov.project.client.repository.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class FindClientServiceTest {

    private static final long ID = 505L;

    @Mock
    private ClientRepository repository;
    private FindClientService sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new FindClientService(repository);
    }

    @Test
    @DisplayName("Проверка метода получения имени клиента по его идентификатору.")
    void getClientNameById() {
        Mockito.doReturn(getPrepareClient()).when(repository).getClientById(ID);
        Assertions.assertEquals("Вася", sut.getClientNameById(ID));
    }

    @Test
    void getIdByLastName() {
        //TODO write test
    }

    @Test
    void getAllClient() {
        //TODO write test
    }

    @Test
    void mapToClientDTO() {
        //TODO write test
    }

    private Client getPrepareClient() {
        return new Client.Builder()
                .withId(ID)
                .withName("Вася")
                .withLastName("Тёркин")
                .build();
    }

}