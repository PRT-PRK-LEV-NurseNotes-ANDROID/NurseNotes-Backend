package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActivityToActivityEntityConverter implements Converter<Activity,ActivityEntity> {
    @Override
    public ActivityEntity convert(Activity source) {
        return ActivityEntity.builder()
                .id(source.getId())
                .travelTime(source.getTravelTime())
                .timeSpent(source.getTimeSpent())
                .type(source.getType())
                .date(source.getDate())
                .build();
    }
}
