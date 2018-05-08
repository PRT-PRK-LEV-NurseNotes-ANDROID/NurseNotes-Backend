package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientEntityConverter implements Converter<Client,ClientEntity> {
    @Override
    public ClientEntity convert(Client source) {
        return ClientEntity.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .age(source.getAge())
                .signature(source.getSignature())
                .phoneNumber(source.getPhoneNumber())
                .address(source.getAddress())
                .wage(source.getWage())
                .build();
    }
}
