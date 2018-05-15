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

//    @Autowired
//    private AbstractValidator<ClientRequest> clientRequestAbstractValidator;

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
//    @Override
//    public Client addClient(ClientRequest client) throws BaseException {
//        Objects.requireNonNull(client, "clientrequest not null");
//        log.trace(">> save: [client:{}]", client);
//        clientRequestAbstractValidator.validate(client);
//        Client convert = conversionService.convert(client, Client.class);
//        ClientEntity clientEntity = conversionService.convert(client, ClientEntity.class);
////        Client convert = conversionService.convert(clientEntity,Client.class);
//        clientRepository.save(clientEntity);
//        log.trace("<< save: [client:{}]", client);
//        return convert;
//    }
    @Override
    public Client addClient(Client gym) throws BaseException {
//        clientRequestAbstractValidator.validate(gym);
        log.trace(">> save: [gym:{}]", gym);
        Client convert = conversionService.convert(clientRepository.save(conversionService.convert(gym, ClientEntity.class)), Client.class);
        log.trace("<< save: [gym:{}]", gym);
        return convert;
    }

}
