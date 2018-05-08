package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Login;

public interface LoginService {

    /**
     * This service is for registration of an employee.
     * After validation it will be stored in the DB.
     *
     * @param login is the employee to be registered.
     * @return It saves the employee in the DB.
     * @throws BaseException
     */
    Login register(Login login) throws BaseException;

    /**
     *
     * @param username is the key to find by.
     * @return the employee by name.
     */
    Login findByUsername(String username);

}
