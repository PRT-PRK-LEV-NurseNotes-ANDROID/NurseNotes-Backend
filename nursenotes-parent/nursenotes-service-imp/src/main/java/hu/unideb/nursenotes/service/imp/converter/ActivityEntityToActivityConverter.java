package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActivityEntityToActivityConverter implements Converter<ActivityEntity, Activity> {

    @Override
    public Activity convert(ActivityEntity activityEntity) {
        return Activity.builder()
                .id(activityEntity.getId())
                .travelTime(activityEntity.getTravelTime())
                .timeSpent(activityEntity.getTimeSpent())
                .type(activityEntity.getType())
                .date(activityEntity.getDate())
                .build();
    }
}
