package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientRequestToClientConverter implements Converter<ClientRequest, Client> {

    @Override
    public Client convert(ClientRequest clientRequest) {
        if (clientRequest == null) {
            return null;
        }
        return Client.builder()
                .firstName(clientRequest.getFirstName())
                .lastName(clientRequest.getLastName())
                .age(clientRequest.getAge())
                .signature(clientRequest.getFirstName())
                .phoneNumber(clientRequest.getPhoneNumber())
                .address(clientRequest.getAddress())
                .wage(clientRequest.getWage())
                .build();
    }
}
