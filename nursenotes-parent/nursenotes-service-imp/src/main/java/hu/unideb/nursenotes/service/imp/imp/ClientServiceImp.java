package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.repository.ClientRepository;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ClientService;
import hu.unideb.nursenotes.service.imp.converter.ClientEntityListToClientListConverter;
import hu.unideb.nursenotes.service.imp.converter.ClientEntityToClientConverter;
import hu.unideb.nursenotes.service.imp.converter.ClientListToClientResponseListConverter;
import hu.unideb.nursenotes.service.imp.converter.ClientToClientEntityConverter;
import hu.unideb.nursenotes.service.imp.validator.AbstractValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
/**
 * This class manages the clients.
 * This class is annotated by
 * {@link org.springframework.stereotype.Service},
 * it is a more specificated
 * {@link org.springframework.stereotype.Component Component}.
 * The
 * {@link org.springframework.transaction.annotation
 * .Transactional Transactional}
 * annotation gets the transactions
 * join the existing annotations or create on if not there is no existing one.
 */

/**
 * {@link lombok.extern.slf4j.Slf4j Logger} is needed for logging.
 */
@Slf4j
@Service
public class ClientServiceImp implements ClientService {

    /**
     * The ClientRepository derives from
     * {@Link ClientRepository} ClientRepository.
     * This data member is wired with the help of
     * {@link Autowired} annotation, by Spring.
     * The needful operations of an activity
     * can be reached by via this data member.
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * A service interface for type conversion.
     * This is the entry point into the convert system.
     * Call {<T> T convert(Object source, Class<T> targetType);}
     * to perform a thread-safe type conversion using this system.
     *
     * @author Keith Donald
     * @author Phillip Webb
     * @since 3.0
     */
    @Autowired
    private ConversionService conversionService;

    /**
     * Abstract validator.
     */
    @Autowired
    private AbstractValidator<Client> clientAbstractValidator;

    /**
     * Client converter.
     */
    @Autowired
    private ClientEntityListToClientListConverter clientEntityListToClientListConverter;

    /**
     * Client converter.
     */
    @Autowired
    private ClientListToClientResponseListConverter clientListToClientResponseListConverter;

    /**
     * Client converter.
     */
    @Autowired
    private ClientToClientEntityConverter clientToClientEntityConverter;

    /**
     * Client converter.
     */
    @Autowired
    private ClientEntityToClientConverter clientEntityToClientConverter;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the client is stored in the DB with a generated ID. This method
     * returns the stored client with its ID.
     *
     * @param client is the Client.
     * @return It returns the result of the conversion via conversionService.
     * @throws BaseException
     */
    @Override
    public Client addClient(Client client) throws BaseException {
        clientAbstractValidator.validate(client);
        log.info(">> save: [client:{}]", client);
        Client convert = clientEntityToClientConverter.convert(
                clientRepository.save(clientToClientEntityConverter
                        .convert(client)));
        log.info("<< save: [client:{}]", client);
        return convert;
    }

    /**
     * Update of a client.
     *
     * @param client to be updated.
     * @return client.
     * @throws BaseException as exception.
     */
    @Override
    public Client updateClient(Client client) throws BaseException {
        clientAbstractValidator.validate(client);
        log.info(">> update: [client:{}]", client);
        Client convert = clientEntityToClientConverter.convert(
                clientRepository.save(
                        clientToClientEntityConverter.convert(client)));
        log.info("<< update: [client:{}]", client);
        return convert;
    }

    /**
     * Find client by the ID.
     *
     * @param id of the client.
     * @return client.
     * @throws BaseException as exception.
     */
    @Override
    public Client findClientById(Long id) throws BaseException {
        log.info(">> findClientById: [id:{}]", id);
        if (Objects.isNull(id)) {
            throw new ServiceException("id is NULL");
        }
        ClientEntity clientEntity;
        try {
            clientEntity = clientRepository.findById(id);
        } catch (Exception e) {
            String errorMsg = String.format(
                    "Error on finding client by id:%d.", id);
            throw new ServiceException(errorMsg, e);
        }
        if (Objects.isNull(clientEntity)) {
            String errorMsg = String.format(
                    "Client with id:%d not found.", id);
            throw new EntityNotFoundException(errorMsg);
        }
        Client result = clientEntityToClientConverter
                .convert(clientEntity);
        log.info("<< findClientById: [id:{}]", id);
        return result;
    }

    /**
     * Client list of a user.
     *
     * @param user the employee.
     * @return client response list.
     */
    @Override
    public List<ClientResponse> findUsersClient(User user) {
        List<ClientEntity> byUsers = clientRepository
                .findByUserEntityId(user.getId());
        List<Client> convert = clientEntityListToClientListConverter
                .convert(byUsers);
        return clientListToClientResponseListConverter
                .convert(convert);
    }

}
