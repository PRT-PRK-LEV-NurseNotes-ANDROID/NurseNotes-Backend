package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link Activity} with
 * the help of {Link {@link Converter}} to an {@link ActivityEntity}.
 */
@Component
public class ActivityToActivityEntityConverter
        implements Converter<Activity, ActivityEntity> {

    /**
     * @param source the activity.
     * @return built activity entity.
     */
    @Override
    public final ActivityEntity convert(final Activity source) {
        return ActivityEntity.builder()
                .id(source.getId())
                .travelTime(source.getTravelTime())
                .timeSpent(source.getTimeSpent())
                .type(source.getType())
                .date(source.getDate())
                .build();
    }
}
