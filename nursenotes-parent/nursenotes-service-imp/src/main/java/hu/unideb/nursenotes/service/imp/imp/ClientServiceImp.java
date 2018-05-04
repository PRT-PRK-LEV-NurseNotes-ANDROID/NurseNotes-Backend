package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.repository.ClientRepository;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ClientService;
import hu.unideb.nursenotes.service.imp.converter.ClientEntityToClientConverter;
import hu.unideb.nursenotes.service.imp.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientValidator clientValidator;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private ClientEntityToClientConverter clientEntityToClientConverter;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Client addClient(Client client) throws BaseException {
        clientValidator.validate(client);
        log.trace(">> save: [client:{}]", client);
        Client convert = conversionService.convert(clientRepository.save(conversionService.convert(client, ClientEntity.class)), Client.class);
        log.trace("<< save: [client:{}]", client);
        return convert;
    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public Client updateClient(Client client) throws BaseException {
//        clientValidator.validate(client);
//        log.trace(">> update: [client:{}]", client);
//        Client convert = conversionService.convert(clientRepository.save(conversionService.convert(client, ClientEntity.class)), Client.class);
//        log.trace("<< update: [client:{}]", client);
//        return convert;
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void deleteClient(Long id) throws BaseException {
//        log.trace(">> deleting Client: [id:{}]", id);
//        if (Objects.isNull(id)) {
//            throw new ServiceException("id is null");
//        }
//        ClientEntity clientEntity;
//        try{
//            clientEntity = clientRepository.findById(id);
//        }catch (Exception e){
//            String errMsg = String.format("Error when finding client by id:%d.", id);
//            throw new ServiceException(errMsg, e);
//        }
//        if (Objects.isNull(clientEntity)) {
//            String errMsg = String.format("Client with id:%d was not found.", id);
//            throw new EntityNotFoundException(errMsg);
//        } else {
//            log.trace("<< deleting Customer: [id:{}]", id);
//            clientRepository.delete(id);
//        }
//    }
//
//    @Override
//    public Client findById(Long id) throws BaseException {
//        log.trace(">> findClientById: [id:{}]", id);
//        if (Objects.isNull(id)) {
//            throw new ServiceException("id is NULL");
//        }
//        ClientEntity clientEntity;
//        try{
//            clientEntity = clientRepository.findById(id);
//        }catch (Exception e){
//            String errMsg = String.format("Error when finding client by id:%d.", id);
//            throw new ServiceException(errMsg, e);
//        }
//        if (Objects.isNull(clientEntity)) {
//            String errMsg = String.format("Client with id:%d not found.", id);
//            throw new EntityNotFoundException(errMsg);
//        }
//        Client result = conversionService.convert(clientEntity, Client.class);
//        log.trace("<< finding Client By Id: [id:{}]", id);
//        return result;
//    }

//    @Override
//    public List<Client> findAll(){
//        List<ClientEntity> findAllClient = clientRepository.findAll();
//        return clientEntityToClientConverter.convert(findAllClient);
//    }

//    @Override
//    public Long countClients() {
//        Long countAllClient = clientRepository.countClients();
//        return countAllClient;
//    }
}
