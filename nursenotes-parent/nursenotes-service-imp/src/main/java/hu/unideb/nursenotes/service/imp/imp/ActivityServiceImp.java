package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.repository.ActivityRepository;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.imp.converter.ActivityEntityListToActivityListConverter;
import hu.unideb.nursenotes.service.imp.converter.ActivityEntityToActivityConverter;
import hu.unideb.nursenotes.service.imp.converter.ActivityListToActivityResponseListConverter;
import hu.unideb.nursenotes.service.imp.converter.ActivityToActivityEntityConverter;
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
 * Activity service implementation.
 */
@Slf4j
@Service
public class ActivityServiceImp implements ActivityService {

    /**
     * Activity repository.
     */
    @Autowired
    private ActivityRepository activityRepository;

    /**
     * Conversion service.
     */
    @Autowired
    private ConversionService conversionService;

    /**
     * Activity list converter.
     */
    @Autowired
    private ActivityEntityListToActivityListConverter
            activityEntityListToActivityListConverter;

    /**
     * Activity list converter.
     */
    @Autowired
    private ActivityListToActivityResponseListConverter
            activityListToActivityResponseListConverter;

    @Autowired
    private ActivityEntityToActivityConverter
            activityEntityToActivityConverter;

    @Autowired
    private ActivityToActivityEntityConverter
            activityToActivityEntityConverter;

    /**
     * Activity insert service.
     *
     * @param activity to be added.
     * @return activity domain.
     * @throws BaseException as exception.
     */
    @Override
    public Activity addActivity(Activity activity) throws BaseException {
//        clientAbstractValidator.validate(client);
        log.info(">> save: [activity:{}]", activity);
        Activity convert = activityEntityToActivityConverter.convert(activityRepository.save(activityToActivityEntityConverter.convert(activity)));
        log.info("<< save: [activity:{}]", activity);
        return convert;
    }

    /**
     * @param client to find this client's activities.
     * @return activity list of a client.
     * @throws BaseException as exception.
     */
    @Override
    public List<ActivityResponse> getAllActivityByClient(Client client)
            throws BaseException {
        List<ActivityEntity> activities =
                activityRepository.findByClientId(client.getId());
        List<Activity> convert =
                activityEntityListToActivityListConverter.convert(activities);
        return activityListToActivityResponseListConverter.convert(convert);
    }
}
