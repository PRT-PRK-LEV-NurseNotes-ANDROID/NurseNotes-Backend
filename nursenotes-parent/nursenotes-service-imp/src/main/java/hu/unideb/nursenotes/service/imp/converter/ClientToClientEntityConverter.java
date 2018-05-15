package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientEntityConverter implements Converter<Client, ClientEntity> {

    @Override
    public ClientEntity convert(Client client) {
        return ClientEntity.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .age(client.getAge())
                .signature(client.getSignature())
                .phoneNumber(client.getPhoneNumber())
                .address(client.getAddress())
                .wage(client.getWage())
                .build();
    }
}
