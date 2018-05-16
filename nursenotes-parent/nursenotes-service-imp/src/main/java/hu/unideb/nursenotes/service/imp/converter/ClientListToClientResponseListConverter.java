package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientListToClientResponseListConverter implements Converter<List<Client>, List<ClientResponse>> {

    @Autowired
    private ClientToClientResponseConverter clientToClientResponseConverter;

    @Override
    public List<ClientResponse> convert(List<Client> clients) {
        return clients.stream().map(client -> clientToClientResponseConverter.convert(client)).collect(Collectors.toList());
    }
}
