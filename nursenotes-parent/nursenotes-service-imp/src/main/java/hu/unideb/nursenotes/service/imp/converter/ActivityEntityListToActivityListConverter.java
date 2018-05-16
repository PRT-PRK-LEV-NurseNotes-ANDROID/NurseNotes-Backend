package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Activity converter class.
 */
@Component
public class ActivityEntityListToActivityListConverter
        implements Converter<List<ActivityEntity>, List<Activity>> {

    /**
     * Activity entity converter.
     */
    @Autowired
    private ActivityEntityToActivityConverter
            activityEntityToActivityConverter;

    /**
     * List of activities.
     *
     * @param source activity.
     * @return activity list.
     */
    @Override
    public List<Activity> convert(List<ActivityEntity> source) {
        return source.stream().map(activityEntity ->
                activityEntityToActivityConverter.
                        convert(activityEntity)).
                collect(Collectors.toList());
    }

}
