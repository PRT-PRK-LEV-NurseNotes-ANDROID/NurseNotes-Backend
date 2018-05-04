package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;

import java.util.List;

public interface ActivityService {

    Activity addActivity(Activity activity) throws BaseException;

    Activity updateActivity(Activity activity) throws BaseException;

    void deleteActivity(Long id) throws BaseException;

    Activity findByName(String name) throws BaseException;

    Activity findById(Long id) throws BaseException;

    List<Activity> findClientActivity(Client client);

    List<Activity> findAll();
}
