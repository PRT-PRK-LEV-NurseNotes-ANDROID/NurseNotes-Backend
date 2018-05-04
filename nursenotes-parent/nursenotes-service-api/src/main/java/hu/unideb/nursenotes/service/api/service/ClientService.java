package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Client;

import java.util.List;

public interface ClientService {

    Client addClient(Client client) throws BaseException;

  //  Client updateClient(Client client) throws BaseException;

  //  void deleteClient(Long id) throws BaseException;

  //  Client findById(Long id) throws BaseException;

   // List<Client> findAll();

  //  Long countClients();
}
