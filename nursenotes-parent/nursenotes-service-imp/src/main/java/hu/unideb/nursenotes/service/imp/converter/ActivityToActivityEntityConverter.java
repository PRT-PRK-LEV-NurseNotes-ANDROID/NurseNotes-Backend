package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ActivityToActivityEntityConverter implements Converter<Activity, ActivityEntity> {

    @Autowired
    private ClientToClientEntityConverter clientToClientEntityConverter;

    @Override
    public ActivityEntity convert(Activity activity) {
        return ActivityEntity.builder()
                .id(activity.getId())
                .travelTime(activity.getTravelTime())
                .timeSpent(activity.getTimeSpent())
                .type(activity.getType())
                .date(activity.getDate())
                .clientEntity(clientEntityToClient(activity.getClient()))
                .build();
    }

    private ClientEntity clientEntityToClient(Client source){
        return clientToClientEntityConverter.convert(source);
    }
}
