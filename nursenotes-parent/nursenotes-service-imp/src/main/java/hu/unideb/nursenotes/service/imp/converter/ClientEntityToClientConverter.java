package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientEntityToClientConverter implements Converter<ClientEntity,Client> {
    @Override
    public Client convert(ClientEntity source) {
        return Client.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .age(source.getAge())
                .signature(source.getSignature())
                .phoneNumber(source.getPhoneNumber())
                .wage(source.getWage())
                .build();
    }
}
