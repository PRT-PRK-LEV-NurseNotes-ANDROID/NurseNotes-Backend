package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Activity converter class.
 */
@Component
public class ActivityToActivityResponseConverter implements Converter<Activity, ActivityResponse> {

    @Override
    public ActivityResponse convert(Activity activity) {
        return ActivityResponse.builder()
                .id(activity.getId())
                .travelTime(activity.getTravelTime())
                .timeSpent(activity.getTimeSpent())
                .type(activity.getType())
                .date(activity.getDate())
                .build();
    }
}
