package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityEntityToActivityListConverter implements Converter<List<ActivityEntity>, List<Activity>> {

    @Autowired
    private ActivityEntityToActivityCoverter activityEntityToActivityCoverter;

    public List<Activity> convert(List<ActivityEntity> source){
        return source.stream().map(activity -> activityEntityToActivityCoverter.convert(activity)).collect(Collectors.toList());
    }
}
