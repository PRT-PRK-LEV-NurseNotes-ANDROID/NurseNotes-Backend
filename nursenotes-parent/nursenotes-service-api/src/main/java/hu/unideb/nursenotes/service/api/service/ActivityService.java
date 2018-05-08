package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;

import java.util.List;

/**
 * This interface is about the activities.
 * It describes the services of managing a handling the activities.
 */
public interface ActivityService {

    /**
     *
     * @param activity
     * @return This service creates the given activity in the database.
     * Afterwards 
     * @throws BaseException
     */
    Activity addActivity(Activity activity) throws BaseException;

    //Activity updateActivity(Activity activity) throws BaseException;

    void deleteActivity(Long id) throws BaseException;

    Activity findByName(String name) throws BaseException;

    Activity findById(Long id) throws BaseException;

    List<Activity> findByClientActivity(Client client);

    List<Activity> findAll();
}
