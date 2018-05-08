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
     * This service creates the given activity in the database.
     * Afterwards with the help of ActivityEntity the Activity will be persistent.
     *
     * @param activity
     * @return This service returns the persistent DB Activity.
     * @throws BaseException
     */
    Activity addActivity(Activity activity) throws BaseException;

    //Activity updateActivity(Activity activity) throws BaseException;

    /**
     * This service deletes the given activity from the database by its ID.
     *
     * @param id
     * @throws BaseException
     */
    void deleteActivity(Long id) throws BaseException;

    /**
     * This service is for finding Activities by Name.
     * The right method queries the Name from DB with the matching Name.
     *
     * @param name
     * @return Activity from the DB, that has been transformed into domain via conversionService.
     * @throws BaseException
     */
    Activity findByName(String name) throws BaseException;

    /**
     * This service is for finding Activities by ID.
     * The right method queries the ID from DB with the matching ID.
     *
     * @param id
     * @return Activity from the DB, that has been transformed into domain via conversionService.
     * @throws BaseException
     */
    Activity findById(Long id) throws BaseException;

    /**
     *
     * @param client
     * @return It returns a list of Activities of a chosen Client.
     */
    List<Activity> findByClientActivity(Client client);

    /**
     *
     * @return It returns a list of all Activities.
     */
    List<Activity> findAll();
}
