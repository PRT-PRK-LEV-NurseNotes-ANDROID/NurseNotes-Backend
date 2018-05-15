package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientEntityListToClientListConverter implements Converter<List<ClientEntity>, List<Client>> {

    @Autowired
    private ClientEntityToClientConverter clientEntityToClientConverter;

    @Override
    public List<Client> convert(List<ClientEntity> source) {
        return source.stream().map(clientEntity -> clientEntityToClientConverter.convert(clientEntity)).collect(Collectors.toList());
    }

}
