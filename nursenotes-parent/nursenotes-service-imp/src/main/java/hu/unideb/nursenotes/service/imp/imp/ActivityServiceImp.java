package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.repository.ActivityRepository;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.imp.converter.ActivityEntityToActivityListConverter;
import hu.unideb.nursenotes.service.imp.converter.ClientToClientEntityConverter;
import hu.unideb.nursenotes.service.imp.validator.ActivityValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    /**
     * The ActivityRepository derives from
     * {@Link hu.unideb.nursenotes.persistence.repository.ActivityRepository}
     * ActivityRepository. This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of an activity can be reached by
     * via this data member.
     */
    @Autowired
    private ActivityRepository activityRepository;

    /**
     * A service interface for type conversion. This is the entry point
     * into the convert system.
     * Call {<T> T convert(Object source, Class<T> targetType);}
     * to perform a thread-safe type conversion using this system.
     *
     * @author Keith Donald
     * @author Phillip Webb
     * @since 3.0
     */
    @Autowired
    private ConversionService conversionService;

    /**
     * The ActivityValidator derives from the AbstractValidator class,
     * which validates the class with the help of rules.
     */
    @Autowired
    private ActivityValidator activityValidator;

    /**
     * The ActivityEntityToActivityListConverter converts the ActivityEntity
     * to an ActivityList, in this case
     * we can collect the ActivityEntities into one list.
     */
    @Autowired
    private ActivityEntityToActivityListConverter
            activityEntityToActivityListConverter;

    @Autowired
    private ClientToClientEntityConverter clientToClientEntityConverter;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the activity is stored in the DB with a generated ID.
     * This method returns the stored activity with its ID.
     *
     * @param activity
     * @return It returns the result of the conversion via conversionService.
     * @throws BaseException as an exception.
     */
    @Override
    public final Activity addActivity(final Activity activity)
            throws BaseException {
        activityValidator.validate(activity);
        log.trace(">> save: [activity:{}", activity);
        Activity convert = conversionService.convert(activityRepository.
                        save(conversionService.convert(activity, ActivityEntity.class)),
                Activity.class);
        log.trace("<< save: [activity:{}", activity);
        return convert;
    }

    /**
     * @param date
     * @return It returns the result of findByDate method,
     * that returns the desired activity by its date from the DB.
     * @throws BaseException as the exception.
     */
    @Override
    public final Activity findByDate(final LocalDate date) throws BaseException {
        log.trace(">> findByDate: [date:{}]", date);
        if (Objects.isNull(date)) {
            throw new ServiceException(
                    "Cannot find because the date is NULL");
        }
        ActivityEntity activityEntity;
        try {
            activityEntity = activityRepository.findByDate(date);
        } catch (Exception e) {
            String errMsg = String
                    .format("Error when finding activity by date:%s.", date);
            throw new ServiceException(errMsg, e);
        }
        Activity result = conversionService.convert(activityEntity,
                Activity.class);
        log.trace("<< findByDate: [date:{}]", result);
        return result;
    }

    /**
     * The {@Link findByClientId}
     * method gives back the result.
     *
     * @param client
     * @return It returns a list of activities, of a chosen Client.
     */
    @Override
    public final List<Activity> findByClientActivity(final Client client) {
        ClientEntity findClient = clientToClientEntityConverter.convert(client);

        List<ActivityEntity> findByClient = activityRepository
                .findByClientActivity(findClient);
        return activityEntityToActivityListConverter.convert(findByClient);
    }

    /**
     * In this implementation the method looks for all the Activities by
     * {@Link findAll} method.
     *
     * @return It returns a list of Activities by all Client.
     */
    @Override
    public final List<Activity> findAll() {
        List<ActivityEntity> findAllActivities = activityRepository.findAll();
        return activityEntityToActivityListConverter.convert(findAllActivities);
    }
}
