package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.repository.ClientRepository;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.service.ClientService;
import hu.unideb.nursenotes.service.imp.validator.AbstractValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

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

    @Autowired
    private AbstractValidator<ClientRequest> clientRequestAbstractValidator;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the client is stored in the DB with a generated ID. This method
     * returns the stored client with its ID.
     *
     * @param clientRequest is the Client.
     * @return It returns the result of the conversion via conversionService.
     * @throws BaseException
     */
    @Override
    public Client addClient(ClientRequest clientRequest) throws BaseException {
        Objects.requireNonNull(clientRequest, "clientrequest not null");
        log.trace(">> save: [client:{}]", clientRequest);
        clientRequestAbstractValidator.validate(clientRequest);
        Client convert = conversionService.convert(clientRequest, Client.class);
        ClientEntity clientEntity = conversionService.convert(convert, ClientEntity.class);
        clientRepository.save(clientEntity);
        log.trace("<< save: [client:{}]", clientRequest);
        return convert;
    }

//    /**
//     * @param phoneNumber of the Client to find by.
//     * @return It returns the client by phone number.
//     * @throws BaseException as exception.
//     */
//    @Override
//    public Client findByPhone(String phoneNumber) throws BaseException {
//        ClientEntity clientEntity = clientRepository.findByPhone(phoneNumber);
//        if (clientEntity == null) {
//            return null;
//        } else {
//            return conversionService.convert(clientEntity, Client.class);
//        }
//    }
//
//    /**
//     * @param user is the employee.
//     * @return It returns the clients of an employee.
//     */
////    @Override
////    public List<Client> findByUser(User user) {
////        UserEntity findUser = userToUserEntityConverter.convert(user);
////
////        List<ClientEntity> foundClients = clientRepository
////                .findByUser(findUser);
////
////        return clientEntityToClientListConverter.convert(foundClients);
////    }
//
//    @Override
//    public List<Client> findClientOfEmployee(User user) {
//        return null;
//    }
//
//    /**
//     * @param client the client's first name.
//     * @return The first name converted into Entity.
//     * @throws BaseException is the exception.
//     */
//    @Override
//    public final Client findByFName(final String client) {
//        ClientEntity clientEntity = clientRepository.findByFName(client);
//        if (clientEntity == null) {
//            return null;
//        } else {
//            return conversionService.convert(clientEntity, Client.class);
//        }
//    }
//
//    /**
//     * @param client the client's last name.
//     * @return The last name converted into Entity.
//     * @throws BaseException is the exception.
//     */
//    @Override
//    public final Client findByLName(final String client) {
//        ClientEntity clientEntity = clientRepository.findByLName(client);
//        if (clientEntity == null) {
//            return null;
//        } else {
//            return conversionService.convert(clientEntity, Client.class);
//        }
//    }

    //    /**
//     * In this implementation the method looks for all the Clients by
//     * {@Link findByLoginId} method.
//     *
//     * @return It returns a list of Clients.
//     */
//    @Override
//    public final List<Client> findByUser(User user) {
//        UserEntity foundUser = userToUserEntityConverter.convert(user);
//
//        List<ClientEntity> findByLoginId = clientRepository.findByUser(foundUser);
//        return clientEntityToClientListConverter.convert(findByLoginId);
//    }

//    /**
//     * @param user is the employee.
//     * @return the Client of an employee.
//     */
//    @Override
//    public final List<Client> findClientOfEmployee(final User user) {
//        UserEntity foundUser = userToUserEntityConverter.convert(user);
//
//        List<ClientEntity> findClientOfEmployee = clientRepository.findByUser(foundUser);
//        return clientEntityListToClientListConverter.convert(findClientOfEmployee);
//    }
}
