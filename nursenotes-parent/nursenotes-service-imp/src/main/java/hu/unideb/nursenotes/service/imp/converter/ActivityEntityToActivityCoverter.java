package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActivityEntityToActivityCoverter implements Converter<ActivityEntity,Activity> {
    @Override
    public Activity convert(ActivityEntity source) {
        return Activity.builder()
                .id(source.getId())
                .travelTime(source.getTravelTime())
                .timeSpent(source.getTimeSpent())
                .type(source.getType())
                .date(source.getDate())
                .build();
    }
}
