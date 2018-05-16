package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Client converter class.
 */
@Component
public class ClientEntityToClientConverter
        implements Converter<ClientEntity, Client> {

    /**
     * User entity converter.
     */
    @Autowired
    private UserEntityToUserConverter userEntityToUserConverter;

    /**
     * Client converter.
     *
     * @param clientEntity to convert.
     * @return converted client.
     */
    @Override
    public Client convert(ClientEntity clientEntity) {
        return Client.builder()
                .id(clientEntity.getId())
                .firstName(clientEntity.getFirstName())
                .lastName(clientEntity.getLastName())
                .age(clientEntity.getAge())
                .signature(clientEntity.getSignature())
                .phoneNumber(clientEntity.getPhoneNumber())
                .address(clientEntity.getAddress())
                .wage(clientEntity.getWage())
                .user(userEntityToUser(clientEntity.getUserEntity()))
                .build();
    }


    /**
     * User converter.
     *
     * @param source user entity.
     * @return user domain.
     */
    private User userEntityToUser(UserEntity source) {

        return userEntityToUserConverter.convert(source);
    }
}
