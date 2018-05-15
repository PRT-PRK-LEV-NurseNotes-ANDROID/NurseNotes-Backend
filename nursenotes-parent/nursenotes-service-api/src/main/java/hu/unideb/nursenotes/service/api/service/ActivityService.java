package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;

import java.util.List;

/**
 * This interface is about the activities.
 * It describes the services of managing and handling the activities.
 */
public interface ActivityService {

    Activity addActivity(Activity activity) throws BaseException;

    List<Activity> getAllActivityByClient(Client client) throws BaseException;

}
