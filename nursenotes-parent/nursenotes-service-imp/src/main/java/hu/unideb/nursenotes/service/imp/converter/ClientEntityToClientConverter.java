package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts with the help of {Link {@link Converter}}
 * the {@link ClientEntity} to a {@link Client}.
 */
@Component
public class ClientEntityToClientConverter
        implements Converter<ClientEntity, Client> {

    /**
     * @param source client entity.
     * @return built client.
     */
    @Override
    public final Client convert(final ClientEntity source) {
        return Client.builder()
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
