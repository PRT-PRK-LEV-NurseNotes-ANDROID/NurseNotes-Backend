package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.ServiceException;

/**
 * This interface is for the login.
 * It handles and manages the login.
 */
public interface UserService {

    /**
     * This service is for registration of an employee.
     * After validation it will be stored in the DB.
     *
     * @param user is the employee to be registered.
     * @return It saves the employee in the DB.
     * @throws BaseException      as exception.
     * @throws ViolationException as exception.
     * @throws ServiceException   as exception.
     */
    User register(User user) throws ViolationException,
            ServiceException, BaseException;

    /**
     * @param username is the key to find by.
     * @return the employee by name.
     */
    User findByUsername(String username);
}
