package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
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
public class ActivityListToActivityResponseListConverter
        implements Converter<List<Activity>, List<ActivityResponse>> {

    /**
     * Activity converter.
     */
    @Autowired
    private ActivityToActivityResponseConverter
            activityToActivityResponseConverter;

    /**
     * Activity list converter.
     *
     * @param source list of activity.
     * @return activity response list.
     */
    @Override
    public List<ActivityResponse> convert(List<Activity> source) {
        return source.stream().map(activity ->
                activityToActivityResponseConverter
                        .convert(activity)).collect(Collectors.toList());
    }
}
