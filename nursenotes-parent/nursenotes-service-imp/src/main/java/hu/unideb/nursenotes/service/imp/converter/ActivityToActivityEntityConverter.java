package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link Activity} with the help of {Link {@link Converter}} to an {@link ActivityEntity}.
 */
@Component
public class ActivityToActivityEntityConverter implements Converter<Activity,ActivityEntity> {
    @Override
    public ActivityEntity convert(Activity source) {
        return ActivityEntity.builder()
                .actId(source.getId())
                .actTravelTime(source.getTravelTime())
                .actTimeSpent(source.getTimeSpent())
                .actType(source.getType())
                .actDate(source.getDate())
                .build();
    }
}
