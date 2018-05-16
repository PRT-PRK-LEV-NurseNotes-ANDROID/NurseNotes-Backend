package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Client converter class.
 */
@Component
public class ClientListToClientEntityListConverter
        implements Converter<List<Client>, List<ClientEntity>> {

    /**
     * Client converter.
     */
    @Autowired
    private ClientToClientEntityConverter clientToClientEntityConverter;

    /**
     * Client list converter.
     *
     * @param source client list.
     * @return client entity list.
     */
    @Override
    public List<ClientEntity> convert(List<Client> source) {
        return source.stream().map(clientEntity ->
                clientToClientEntityConverter.convert(clientEntity))
                .collect(Collectors.toList());
    }

}
