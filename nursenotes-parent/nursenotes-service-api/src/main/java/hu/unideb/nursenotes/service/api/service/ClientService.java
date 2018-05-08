package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Client;

import java.util.List;

public interface ClientService {

    /**
     * This service adds the given client to the database.
     * Afterwards with the help of ClientEntity the Client will be persistent.
     *
     * @param client
     * @return This service returns the persistent DB Client.
     * @throws BaseException
     */
    Client addClient(Client client) throws BaseException;

    /**
     * This service updates the data a Client who is already in the DB.
     *
     * @param client the modified Client, to be persisted.
     * @return The updated client, who is already in the DB.
     * @throws BaseException
     */
    Client updateClient(Client client) throws BaseException;

    /**
     * This service deletes the given Client from the database by its ID.
     *
     * @param id of the Client to be deleted.
     * @throws BaseException
     */
    void deleteClient(Long id) throws BaseException;

    /**
     * This service is for finding Clients by ID.
     * The right method queries the ID from DB with the matching ID.
     *
     * @param id of the Client to find by.
     * @return Client from the DB, that has been transformed into domain via conversionService.
     * @throws BaseException
     */
    Client findById(Long id) throws BaseException;

    /**
     *
     * @return It returns a list of all Client.
     */
    List<Client> findAllClient();

    /**
     *
     * @return It returns a long type of counted Clients.
     */
    Long countClients();
}
