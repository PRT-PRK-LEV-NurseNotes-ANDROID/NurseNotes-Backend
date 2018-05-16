package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.service.api.domain.User;

/**
 * User service to handle user interactions.
 */
public interface UserService {

    /**
     * Finds a user by his/her user name.
     *
     * @param username the user name of the user.
     * @return the user with the given user name.
     * @throws BaseException as exception.
     */
    User findByUsername(String username) throws BaseException;

    /**
     * Save user.
     *
     * @param user user object to be saved.
     * @return saved user object.
     * @throws BaseException as exception.
     */
    User save(RegistrationRequest user) throws BaseException;
}
