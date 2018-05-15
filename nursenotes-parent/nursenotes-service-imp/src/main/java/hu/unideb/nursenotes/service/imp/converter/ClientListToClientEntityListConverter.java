package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientListToClientEntityListConverter implements Converter<List<Client>, List<ClientEntity>> {

    @Autowired
    private ClientToClientEntityConverter clientToClientEntityConverter;

    @Override
    public List<ClientEntity> convert(List<Client> source) {
        return source.stream().map(clientEntity -> clientToClientEntityConverter.convert(clientEntity)).collect(Collectors.toList());
    }

}
