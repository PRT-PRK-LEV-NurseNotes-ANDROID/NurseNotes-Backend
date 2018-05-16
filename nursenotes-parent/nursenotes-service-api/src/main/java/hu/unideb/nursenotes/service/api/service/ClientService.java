package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
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
     * Update a client service.
     *
     * @param client the client to be updated.
     * @return updated client.
     * @throws BaseException as exception.
     */
    Client updateClient(Client client) throws BaseException;

    /**
     * Find client by ID.
     * @param id the ID of a client.
     * @return a client.
     * @throws BaseException as exception.
     */
    Client findClientById(Long id) throws BaseException;

    /**
     * It gives back a list of clients, belonging to a user.
     * @param user the employee.
     * @return list of clients.
     * @throws BaseException as exception.
     */
    List<ClientResponse> findUsersClient(User user) throws BaseException;
}
