package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts an {@link ActivityEntity} with the help
 * of {Link {@link Converter}} to an {@link Activity} and provides an ID to it.
 */
@Component
public class ActivityEntityToActivityConverter implements
        Converter<ActivityEntity, Activity> {
    @Override
    public final Activity convert(final ActivityEntity source) {
        return Activity.builder()
                .id(source.getId())
                .travelTime(source.getTravelTime())
                .timeSpent(source.getTimeSpent())
                .type(source.getType())
                .date(source.getDate())
                .build();
    }
}
