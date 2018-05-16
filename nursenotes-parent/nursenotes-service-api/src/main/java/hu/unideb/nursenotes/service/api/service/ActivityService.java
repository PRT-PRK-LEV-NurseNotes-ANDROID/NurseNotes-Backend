package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;

import java.util.List;

/**
 * This interface is about the activities.
 * It describes the services of managing and handling the activities.
 */
public interface ActivityService {

    /**
     * Add activity service.
     *
     * @param activity activity.
     * @return created activity.
     * @throws BaseException as exception.
     */
    Activity addActivity(Activity activity) throws BaseException;

    /**
     * Gives by every activity at a client.
     *
     * @param client the client.
     * @return a list of activities.
     * @throws BaseException as exception.
     */
    List<ActivityResponse> getAllActivityByClient(Client client) throws BaseException;

}
