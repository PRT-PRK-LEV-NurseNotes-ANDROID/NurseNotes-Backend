package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Client converter class.
 */
@Component
public class ClientToClientResponseConverter
        implements Converter<Client, ClientResponse> {

    /**
     * Client response.
     *
     * @param client to be converted.
     * @return response.
     */
    @Override
    public ClientResponse convert(Client client) {
        return ClientResponse.builder()
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
