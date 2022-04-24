package com.akhazov.project.client.repository;

import com.akhazov.project.client.repository.entity.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ClientRepositoryTest {

    private static final String NAME = "Иван";
    private static final String LAST_NAME = "Савин";

    private Client currentClient;
    private Long currentId;

    @Autowired
    private ClientRepository sut;

    @BeforeEach
    @DisplayName("Перед каждым тестовым методом кладём сущность в базу и сохраняем его сгерированный id.")
    void setUp() {
        currentClient = sut.save(prepareClient());
        currentId = currentClient.getId();
    }

    @AfterEach
    @DisplayName("После каждого тестового метода чистим базу.")
    void tearDown() {
        sut.deleteAll();
    }

    @Test
    @DisplayName("Тест получения клиента по идентификатору.")
    void getClientById() {
        Client clientById = sut.getClientById(currentId);
        Assertions.assertEquals(currentClient, clientById);
    }

    @Test
    void getIDByLastName() {
        //TODO write test
    }

    @Test
    void getAllClient() {
        //TODO write test
    }

    private Client prepareClient() {
        return new Client.Builder()
                .withName(NAME)
                .withLastName(LAST_NAME)
                .build();
    }

}