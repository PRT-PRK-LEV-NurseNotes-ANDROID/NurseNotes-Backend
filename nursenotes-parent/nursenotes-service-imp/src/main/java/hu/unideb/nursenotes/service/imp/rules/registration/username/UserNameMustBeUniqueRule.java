package hu.unideb.nursenotes.service.imp.rules.registration.username;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.service.LoginService;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class checks if the Username is unique at the login.
 * If it is not unique, it returns a {@link Violation},
 * else it will proceed.
 */
@Component
public class UserNameMustBeUniqueRule implements Rule<Login> {

    @Autowired
    private LoginService loginService;

    @Override
    public List<Violation> validate(Login request){
        List<Violation> result = Collections.<Violation>emptyList();
        String username = request.getUserName();
        Login login;
        if(username != null){
            login = loginService.findByUsername(username);
            if (login != null){
                result = Arrays.asList(Violation.builder()
                        .field("Username")
                        .validationMessage("Choose an other username!")
                        .build());
            }
        }
        return result;
    }
}
