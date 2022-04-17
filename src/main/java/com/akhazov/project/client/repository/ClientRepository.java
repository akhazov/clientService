package com.akhazov.project.client.repository;

import com.akhazov.project.client.repository.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

    /**
     * Возвращает клиента по идентификатору.
     *
     * @param id идентификатор
     * @return найденый клиент
     */
    @Query("SELECT c FROM Client c WHERE c.id = :id")
    Client getClientById(@Param("id") String id);

    @Query("SELECT e FROM Client e where e.lastName = :lastName")
    Client getIDByLastName(@Param("lastName") String lastName);

    @Query("SELECT e FROM Client e")
    List<Client> getAllClient();

}
