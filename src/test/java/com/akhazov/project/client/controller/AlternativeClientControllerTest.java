package com.akhazov.project.client.controller;

import com.akhazov.project.client.service.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class AlternativeClientControllerTest {

    @MockBean
    private ClientService clientService;

    @Autowired
    MockMvc mockController;

    @Test
    @DisplayName("Проверка работы энпойнта /client/name/id")
    void getClientNameById() throws Exception {
        Mockito.doReturn("Сашок").when(clientService).getClientNameById(331L);
        mockController.perform(get("/client/name/id?clientId=331"))
                .andExpect(status().isOk())
                .andExpect(content().string("Имя клиента с ID: 331 Сашок"));
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