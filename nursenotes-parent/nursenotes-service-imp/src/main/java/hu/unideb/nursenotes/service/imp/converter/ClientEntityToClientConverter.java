package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientEntityToClientConverter implements Converter<ClientEntity, Client> {

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
                .build();
    }
}
