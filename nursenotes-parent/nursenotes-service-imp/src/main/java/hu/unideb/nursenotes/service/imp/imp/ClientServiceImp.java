package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.repository.ClientRepository;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ClientService;
import hu.unideb.nursenotes.service.imp.converter.ClientEntityToClientConverter;
import hu.unideb.nursenotes.service.imp.converter.ClientEntityToClientListConverter;
import hu.unideb.nursenotes.service.imp.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
/**
 * This class manages the clients.
 * This class is annotated by {@link org.springframework.stereotype.Service Service},
 * it is a more specificated {@link org.springframework.stereotype.Component Component}.
 * The {@link org.springframework.transaction.annotation.Transactional Transactional} annotation gets the transactions
 * join the existing annotations or create on if not there is no existing one.
 */

/**
 * {@link org.slf4j.Logger Logger} is needed for logging.
 */
@Slf4j
@Service
public class ClientServiceImp implements ClientService {

    /**
     * The ClientRepository derives from {@Link hu.inf.unideb.nursenotes.persistence.repository.ClientRepository} ClientRepository.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of an activity can be reached by via this data member.
     */
    @Autowired
    private ClientRepository clientRepository;
    /**
     * The ClientValidator derives from the AbstractValidator class, which validates the class with the help of rules.
     */
    @Autowired
    private ClientValidator clientValidator;
    /**
     * A service interface for type conversion. This is the entry point into the convert system.
     * Call {<T> T convert(Object source, Class<T> targetType);} to perform a thread-safe type conversion using this system.
     *
     * @author Keith Donald
     * @author Phillip Webb
     * @since 3.0
     */
    @Autowired
    private ConversionService conversionService;
    /**
     * The ClientEntityToClientListConverter converts the ClientEntity to a ClientList, in this case
     * we can collect the ClientEntities into one list.
     */
    @Autowired
    private ClientEntityToClientListConverter clientEntityToClientListConverter;

    /**
     * In this implementation, in the method with the help of {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the client is stored in the DB with a generated ID. This method returns the stored client with its ID.
     *
     * @param client
     * @return It returns the result of the conversion via conversionService.
     *
     * @throws BaseException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Client addClient(Client client) throws BaseException {
        clientValidator.validate(client);
        log.trace(">> save: [client:{}]", client);
        Client convert = conversionService.convert(clientRepository.save(conversionService.convert(client, ClientEntity.class)), Client.class);
        log.trace("<< save: [client:{}]", client);
        return convert;
    }

    /**
     * In this implementation, in the method with the help of {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the client is saved and already has an ID. So no new member will be created, but updated via its ID.
     *
     * @param client
     * @return It returns the result of the conversion via conversionService.
     *
     * @throws BaseException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Client updateClient(Client client) throws BaseException {
        clientValidator.validate(client);
        log.trace(">> update: [client:{}]", client);
        Client convert = conversionService.convert(clientRepository.save(conversionService.convert(client, ClientEntity.class)), Client.class);
        log.trace("<< update: [client:{}]", client);
        return convert;
    }
    /**
     * In this implementation a client can be deleted by finding it by its ID.
     *
     * @param id
     * @throws BaseException
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteClient(Long id) throws BaseException {
        log.trace(">> deleting Client: [id:{}]", id);
        if (Objects.isNull(id)) {
            throw new ServiceException("id is null");
        }
        ClientEntity clientEntity;
        try{
            clientEntity = clientRepository.findById(id);
        }catch (Exception e){
            String errMsg = String.format("Error when finding client by id:%d.", id);
            throw new ServiceException(errMsg, e);
        }
        if (Objects.isNull(clientEntity)) {
            String errMsg = String.format("Client with id:%d was not found.", id);
            throw new EntityNotFoundException(errMsg);
        } else {
            log.trace("<< deleting Customer: [id:{}]", id);
            clientRepository.delete(id);
        }
    }
    /**
     *The {@Link hu.unideb.inf.nursenotes.persistence.repository.ClientRepository#findById} method gives back the result.
     *
     * @param id
     * @return It returns the result of findById method, that returns the desired client by its ID from the DB.
     *
     * @throws BaseException
     */
    @Override
    public Client findById(Long id) throws BaseException {
        log.trace(">> findClientById: [id:{}]", id);
        if (Objects.isNull(id)) {
            throw new ServiceException("id is NULL");
        }
        ClientEntity clientEntity;
        try{
            clientEntity = clientRepository.findById(id);
        }catch (Exception e){
            String errMsg = String.format("Error when finding client by id:%d.", id);
            throw new ServiceException(errMsg, e);
        }
        if (Objects.isNull(clientEntity)) {
            String errMsg = String.format("Client with id:%d not found.", id);
            throw new EntityNotFoundException(errMsg);
        }
        Client result = conversionService.convert(clientEntity, Client.class);
        log.trace("<< finding Client By Id: [id:{}]", id);
        return result;
    }
    /**
     * In this implementation the method looks for all the Clients by
     * {@Link hu.unideb.inf.nursenotes.persistence.repository.ClientRepository#findAllClient} method.
     *
     * @return It returns a list of Clients.
     */
    @Override
    public List<Client> findAllClient(){
        List<ClientEntity> findAllClient = clientRepository.findAllClient();
        return clientEntityToClientListConverter.convert(findAllClient);
    }

    /**
     *
     * @return It returns a Long value, with the number of Clients.
     */
    @Override
    public Long countClients() {
        Long countAllClient = clientRepository.countClients();
        return countAllClient;
    }
}
