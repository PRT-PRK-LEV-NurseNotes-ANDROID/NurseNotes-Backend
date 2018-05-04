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

@Slf4j
@Service
public class ActivityServiceImp implements ActivityService{

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private ActivityValidator activityValidator;

    @Autowired
    private ActivityEntityToActivityListConverter activityEntityToActivityListConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Activity addActivity(Activity activity) throws BaseException{
        activityValidator.validate(activity);
        log.trace(">> save: [activity:{}", activity);
        Activity convert = conversionService.convert(activityRepository.save(conversionService.convert(activity, ActivityEntity.class)), Activity.class);
        log.trace("<< save: [activity:{}", activity);
        return convert;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Activity updateActivity(Activity activity) throws BaseException {
        activityValidator.validate(activity);
        log.trace(">> update: [activity:{}", activity);
        Activity convert = conversionService.convert(activityRepository.save(conversionService.convert(activity, ActivityEntity.class)), Activity.class);
        log.trace("<< update: [activity:{}", activity);
        return convert;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteActivity(Long id) throws BaseException {
        log.trace(">> deleteActivity: [id:{}]", id);
        if (Objects.isNull(id)) {
            throw new ServiceException("id is NULL");
        }
        ActivityEntity activityEntity;
        try{
            activityEntity = activityRepository.findById(id);
        }catch (Exception e){
            String errMsg = String.format("Error when finding activity by id:%d.", id);
            throw new ServiceException(errMsg, e);
            }
        if(Objects.isNull(activityEntity)){
            String errMsg = String.format("Activity with id:%id was not found.", id);
            throw new EntityNotFoundException(errMsg);
        } else {
            log.trace("<< deleteActivity: [id:{}]", id);
            activityRepository.delete(id);
            }
        }

    @Override
    public Activity findByName(String name) throws BaseException {
        log.trace(">> findByName: [name:{}]", name);
        if (Objects.isNull(name)) {
            throw new ServiceException("name is NULL");
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

    @Override
    public Activity findById(Long id) throws BaseException {
        log.trace(">> findById: [id:{}]", id);
        if (Objects.isNull(id)) {
            throw new ServiceException("id is NULL");
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

    @Override
    public List<Activity> findClientActivity(Client client) {
        List<ActivityEntity> findbyClient = activityRepository.findByClientId(client.getId());
        return activityEntityToActivityListConverter.convert(findbyClient);
    }

    @Override
    public List<Activity> findAll() {
        List<ActivityEntity> findAllActivities = activityRepository.findAll();
        return activityEntityToActivityListConverter.convert(findAllActivities);
    }

}
