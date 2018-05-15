package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityEntityListToActivityListConverter implements Converter<List<ActivityEntity>, List<Activity>> {

    @Autowired
    private ActivityEntityToActivityConverter activityEntityToActivityConverter;

    @Override
    public List<Activity> convert(List<ActivityEntity> source) {
        return source.stream().map(activityEntity -> activityEntityToActivityConverter.convert(activityEntity)).collect(Collectors.toList());
    }

}
