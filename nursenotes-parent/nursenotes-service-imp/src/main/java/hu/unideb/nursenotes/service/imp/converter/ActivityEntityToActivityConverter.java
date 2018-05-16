package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Activity converter class.
 */
@Component
public class ActivityEntityToActivityConverter
        implements Converter<ActivityEntity, Activity> {

    /**
     * Client entity converter.
     */
    @Autowired
    private ClientEntityToClientConverter
            clientEntityToClientConverter;

    /**
     * Activity converter.
     *
     * @param activityEntity activity entity.
     * @return activity domain.
     */
    @Override
    public Activity convert(ActivityEntity activityEntity) {
        return Activity.builder()
                .id(activityEntity.getId())
                .travelTime(activityEntity.getTravelTime())
                .timeSpent(activityEntity.getTimeSpent())
                .type(activityEntity.getType())
                .date(activityEntity.getDate())
                .client(clientEntityToClient(activityEntity.getClient()))
                .build();
    }

    /**
     * @param source client entity.
     * @return client domain.
     */
    private Client clientEntityToClient(ClientEntity source) {
        return clientEntityToClientConverter.convert(source);
    }
}
