package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.repository.ActivityRepository;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.imp.converter.ActivityEntityToActivityListConverter;
import hu.unideb.nursenotes.service.imp.validator.ActivityValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * This class manages the activities at a client.
 * This class is annotated by {@link org.springframework.stereotype.Service Service},
 * it is a more specificated {@link org.springframework.stereotype.Component Component}.
 * The {@link org.springframework.transaction.annotation.Transactional Transactional} annotation gets the transactions
 * join the existing annotations or create on if not there is no existing one.
 */

/**
 * {@link org.slf4j.Logger Logger} is needed for logging.
 */
@Slf4j
@Service
public class ActivityServiceImp implements ActivityService{

    /**
     * The ActivityRepository derives from {@Link hu.inf.unideb.nursenotes.persistence.repository.ActivityRepository} ActivityRepository.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of an activity can be reached by via this data member.
     */
    @Autowired
    private ActivityRepository activityRepository;

    /**
     * A service interface for type conversion. This is the entry point into the convert system.
     * Call {<T> T convert(Object source, Class<T> targetType);} to perform a thread-safe type conversion using this system.
     *
     * @author Keith Donald
     * @author Phillip Webb
     * @since 3.0
     */
    @Autowired
    private ConversionService conversionService;

    /**
     * The ActivityValidator derives from the AbstractValidator class, which validates the class with the help of rules.
     */
    @Autowired
    private ActivityValidator activityValidator;

    /**
     * The ActivityEntityToActivityListConverter converts the ActivityEntity to an ActivityList, in this case
     * we can collect the ActivityEntities into one list.
     */
    @Autowired
    private ActivityEntityToActivityListConverter activityEntityToActivityListConverter;

    /**
     *
     * @param activity
     * @return It returns the result of the conversion via conversionService.
     * In this implementation, in the method with the help of {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the activity is stored in the DB with a generated ID. This method returns the stored activity with its ID.
     * @throws BaseException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Activity addActivity(Activity activity) throws BaseException{
        activityValidator.validate(activity);
        log.trace(">> save: [activity:{}", activity);
        Activity convert = conversionService.convert(activityRepository.save(conversionService.convert(activity, ActivityEntity.class)), Activity.class);
        log.trace("<< save: [activity:{}", activity);
        return convert;
    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public Activity updateActivity(Activity activity) throws BaseException {
//        activityValidator.validate(activity);
//        log.trace(">> update: [activity:{}", activity);
//        Activity convert = conversionService.convert(activityRepository.save(conversionService.convert(activity, ActivityEntity.class)), Activity.class);
//        log.trace("<< update: [activity:{}", activity);
//        return convert;
//    }

    /**
     *
     * @param id
     * @throws BaseException
     * In this implementation an activity can be deleted by finding it by its ID.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteActivity(Long id) throws BaseException {
        log.trace(">> deleteActivity: [id:{}]", id);
        if (Objects.isNull(id)) {
            throw new ServiceException("Cannot delete because it is NULL");
        }
        ActivityEntity activityEntity;
        try{
            activityEntity = activityRepository.findById(id);
        }catch (Exception e){
            String errMsg = String.format("Error when finding activity by id:%d.", id);
            throw new ServiceException(errMsg, e);
            }
        if(Objects.isNull(activityEntity)){
            String errMsg = String.format("Activity with id:%d was not found.", id);
            throw new EntityNotFoundException(errMsg);
        } else {
            log.trace("<< deleteActivity: [id:{}]", id);
            activityRepository.delete(id);
            }
        }

    /**
     *
      * @param name
     * @return It returns the result of findByName method, that returns the desired activity by its name from the DB.
     * @throws BaseException
     */
    @Override
    public Activity findByName(String name) throws BaseException {
        log.trace(">> findByName: [name:{}]", name);
        if (Objects.isNull(name)) {
            throw new ServiceException("Cannot find because the name is NULL");
        }
        ActivityEntity activityEntity;
        try{
            activityEntity = activityRepository.findByName(name);
        }catch (Exception e){
            String errMsg = String.format("Error when finding activity by name:%s.", name);
            throw new ServiceException(errMsg, e);
        }
        Activity result = conversionService.convert(activityEntity, Activity.class);
        log.trace("<< findByName: [name:{}]", result);
        return result;
    }

    /**
     *
     * @param id
     * @return It returns the result of findById method, that returns the desired activity by its ID from the DB.
     * The {@Link hu.unideb.inf.nursenotes.persistence.repository.ActivityRepository#findById} method gives back the result.
     * @throws BaseException
     */
    @Override
    public Activity findById(Long id) throws BaseException {
        log.trace(">> findById: [id:{}]", id);
        if (Objects.isNull(id)) {
            throw new ServiceException("Cannot find because the id is NULL");
        }
        ActivityEntity activityEntity;
        try{
            activityEntity = activityRepository.findById(id);
        }catch (Exception e){
            String errMsg = String.format("Error when finding activity by id:%d.", id);
            throw new ServiceException(errMsg, e);
        }
        if (Objects.isNull(activityEntity)) {
            String errMsg = String.format("Activity with id:%d was not found.", id);
            throw new EntityNotFoundException(errMsg);
        }
        Activity result = conversionService.convert(activityEntity, Activity.class);
        log.trace("<< findActivityById: [id:{}]", id);
        return result;
    }

    /**
     *
     * @param client
     * @return It returns a list of activities, of a chosen Client.
     * The {@Link hu.unideb.inf.nursenotes.persistence.repository.ActivityRepository#findByClientId} method gives back the result.
     */
    @Override
    public List<Activity> findByClientActivity(Client client) {
        List<ActivityEntity> findByClient = activityRepository.findByClientId(client.getId());
        return activityEntityToActivityListConverter.convert(findByClient);
    }

    /**
     * In this implementation the method looks for all the Activities by
     * {@Link hu.unideb.inf.nursenotes.persistence.repository.ActivityRepository#findAll} method.
     * @return It returns a list of Activities by all Client.
     */
    @Override
    public List<Activity> findAll() {
        List<ActivityEntity> findAllActivities = activityRepository.findAll();
        return activityEntityToActivityListConverter.convert(findAllActivities);
    }

}
