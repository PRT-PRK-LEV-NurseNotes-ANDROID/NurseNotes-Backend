package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link Client} with the help of {Link {@link Converter}} to a {@link ClientEntity}.
 */
@Component
public class ClientToClientEntityConverter implements Converter<Client,ClientEntity> {
    @Override
    public ClientEntity convert(Client source) {
        return ClientEntity.builder()
                .cliId(source.getId())
                .cliFirstName(source.getFirstName())
                .cliLastName(source.getLastName())
                .cliAge(source.getAge())
                .cliSignature(source.getSignature())
                .cliPhoneNumber(source.getPhoneNumber())
                .cliAddress(source.getAddress())
                .cliWage(source.getWage())
                .build();
    }
}
