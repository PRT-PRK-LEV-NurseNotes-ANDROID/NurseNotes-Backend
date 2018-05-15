package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.service.api.domain.Client;

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

}
