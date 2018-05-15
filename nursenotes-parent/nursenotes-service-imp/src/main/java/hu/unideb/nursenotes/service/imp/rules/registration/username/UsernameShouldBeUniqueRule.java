package hu.unideb.nursenotes.service.imp.rules.registration.username;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.service.UserService;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Validates username uniqueness.
 */
@Component
public class UsernameShouldBeUniqueRule implements Rule<RegistrationRequest> {

    @Autowired
    private UserService userService;

    @Override
    public List<Violation> validate(RegistrationRequest request) throws BaseException {
        List<Violation> result = Collections.<Violation>emptyList();
        String username = request.getUsername();
        if (StringUtils.isNotBlank(username)) {
            try {
                userService.findByUsername(username);
                result = Arrays.asList(Violation.builder()
                        .field("username")
                        .validationMessage("uniqe rule")
                        .build());
            } catch (EntityNotFoundException e) {
                //user does not exists, result = emptylist.
            }
        }
        return result;
    }
}
