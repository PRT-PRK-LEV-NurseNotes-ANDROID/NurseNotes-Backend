package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActivityToActivityEntityConverter implements Converter<Activity, ActivityEntity> {

    @Override
    public ActivityEntity convert(Activity activity) {
        return ActivityEntity.builder()
                .id(activity.getId())
                .travelTime(activity.getTravelTime())
                .timeSpent(activity.getTimeSpent())
                .type(activity.getType())
                .date(activity.getDate())
                .build();
    }
}
