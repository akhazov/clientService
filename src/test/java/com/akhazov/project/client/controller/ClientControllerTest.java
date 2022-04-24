package com.akhazov.project.client.controller;

import com.akhazov.project.client.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ClientControllerTest {

    public static final long ID = 123L;
    @Mock
    private ClientService clientService;
    private ClientController sut;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new ClientController(clientService);
    }

    @Test
    @DisplayName("Тест работы метода контроллера по получению ответа с  именем клиента по id.")
    void getClientNameById() {
        Mockito.when(clientService.getClientNameById(ID)).thenReturn("Николай");
        String response = sut.getClientNameById(ID);
        Assertions.assertTrue(response.endsWith("Николай"));
    }

    @Test
    @DisplayName("Дополнительный тест работы метода контроллера, с проверкой формата ответа.")
    void getClientNameById_checkFormatResponse() {
        Mockito.when(clientService.getClientNameById(ID)).thenReturn("Лаврентий");
        Assertions.assertEquals("Имя клиента с ID: 123 Лаврентий", sut.getClientNameById(ID));
    }


    @Test
    void getIdByLastName() {
        //TODO write test
    }

    @Test
    void getAllClient() {
        //TODO write test
    }

}