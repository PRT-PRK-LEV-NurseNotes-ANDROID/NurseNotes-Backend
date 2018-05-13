package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link Client} with
 * the help of {Link {@link Converter}} to a {@link ClientEntity}.
 */
@Component
public class ClientToClientEntityConverter
        implements Converter<Client, ClientEntity> {

    /**
     * @param source client.
     * @return built client entity.
     */
    @Override
    public final ClientEntity convert(final Client source) {
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
