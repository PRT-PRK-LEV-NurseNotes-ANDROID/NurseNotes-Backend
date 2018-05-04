package hu.unideb.nursenotes.service.api.service;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Login;

public interface LoginService {

    Login register(Login login) throws BaseException;

    Login findByUsername(String username);

}
