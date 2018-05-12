package hu.unideb.nursenotes.service.imp.rules.registration.username;

import com.google.common.base.Strings;
import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.service.UserService;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class checks if the Username is blank at the login or not.
 * If it is blank, it returns with a {@link Violation} message,
 * else it will proceed.
 */
@Component
public class UserNameNotBlankRule implements Rule<User> {

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    @Override
    public final List<Violation> validate(final User request)
            throws BaseException {
        return Strings.isNullOrEmpty(request.getUserName())
                ? Arrays.asList(Violation.builder()
                        .vField("Username")
                        .validationMessage("Cannot be blank!")
                        .build())
                : Collections.<Violation>emptyList();
    }
}
