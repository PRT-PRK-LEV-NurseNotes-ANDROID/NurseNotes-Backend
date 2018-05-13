package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;

import java.util.List;

/**
 * This interface is for the Client.
 * It handles and manages the Client-connected services.
 */
public interface ClientService {

    /**
     * This service adds the given client to the database.
     * Afterwards with the help of ClientEntity the Client will be persistent.
     *
     * @param client is the Client to add.
     * @return This service returns the persistent DB Client.
     * @throws BaseException as exception.
     */
    Client addClient(Client client) throws BaseException;

    /**
     * This service is for finding Clients by ID.
     * The right method queries the ID from DB with the matching ID.
     *
     * @param phoneNumber of the Client to find by.
     * @return Client from the DB, that has been transformed
     * into domain via conversionService.
     * @throws BaseException as exception.
     */
    Client findByPhone(String phoneNumber) throws BaseException;

    /**
     * @return It returns a list of all Client.
     */

    List<Client> findByUser(User user);

    List<Client> findClientOfEmployee(User user);

    Client findByFName(String client);

    Client findByLName(String client);
}
