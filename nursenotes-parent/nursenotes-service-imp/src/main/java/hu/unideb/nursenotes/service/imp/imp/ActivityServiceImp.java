package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.repository.ActivityRepository;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.imp.converter.ActivityEntityListToActivityListConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class manages the activities at a client.
 * This class is annotated by
 * {@link org.springframework.stereotype.Service Service},
 * it is a more specificated
 * {@link org.springframework.stereotype.Component Component}.
 * The
 * {@link org.springframework.transaction.annotation.Transactional}
 * annotation gets the transactions
 * join the existing annotations or create on if not there is no existing one.
 */

/**
 * {@link lombok.extern.slf4j.Slf4j Logger} is needed for logging.
 */
@Slf4j
@Service
public class ActivityServiceImp implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    ActivityEntityListToActivityListConverter activityEntityListToActivityListConverter;

    @Override
    public Activity addActivity(Activity activity) throws BaseException {
//        clientAbstractValidator.validate(client);
        log.trace(">> save: [activity:{}]", activity);
        Activity convert = conversionService.convert(activityRepository.save(conversionService.convert(activity, ActivityEntity.class)), Activity.class);
        log.trace("<< save: [activity:{}]", activity);
        return convert;    }

    @Override
    public List<Activity> getAllActivityByClient(Client client) throws BaseException {
        List<ActivityEntity> activities = activityRepository.findByClientId(client.getId());
        return activityEntityListToActivityListConverter.convert(activities);
    }
}
