package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class converts the {@link ActivityEntity}
 * with the help of {Link {@link Converter}} to a List.
 */
@Component
public class ActivityEntityToActivityListConverter implements
        Converter<List<ActivityEntity>, List<Activity>> {

    /**
     * Activity entity converter.
     */
    @Autowired
    private ActivityEntityToActivityConverter activityEntityToActivityConverter;

    /**
     * @param source activty entity to be converted.
     * @return converted activity to a list.
     */
    public final List<Activity> convert(final List<ActivityEntity> source) {
        return source.stream().map(activity ->
                activityEntityToActivityConverter.
                        convert(activity)).collect(Collectors.toList());
    }
}
