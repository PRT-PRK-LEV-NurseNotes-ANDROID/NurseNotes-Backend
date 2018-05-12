package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.exception.ServiceException;

/**
 * This interface is for the login.
 * It handles and manages the login.
 */
public interface LoginService {

    /**
     * This service is for registration of an employee.
     * After validation it will be stored in the DB.
     *
     * @param login is the employee to be registered.
     * @return It saves the employee in the DB.
     * @throws BaseException as exception.
     * @throws ViolationException as exception.
     * @throws ServiceException as exception.
     */
    Login register(Login login) throws ViolationException,
            ServiceException, BaseException;

    /**
     *
     * @param username is the key to find by.
     * @return the employee by name.
     */
    Login findByUsername(String username);

}
