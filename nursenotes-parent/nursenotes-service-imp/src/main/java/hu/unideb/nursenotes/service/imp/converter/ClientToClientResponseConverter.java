package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientResponseConverter implements Converter<Client, ClientResponse> {

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
