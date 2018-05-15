package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityListToActivityEntityListConverter implements Converter<List<Activity>, List<ActivityEntity>> {

    @Autowired
    private ActivityToActivityEntityConverter activityToActivityEntityConverter;

    @Override
    public List<ActivityEntity> convert(List<Activity> source) {
        return source.stream().map(activity -> activityToActivityEntityConverter.convert(activity)).collect(Collectors.toList());
    }

}
