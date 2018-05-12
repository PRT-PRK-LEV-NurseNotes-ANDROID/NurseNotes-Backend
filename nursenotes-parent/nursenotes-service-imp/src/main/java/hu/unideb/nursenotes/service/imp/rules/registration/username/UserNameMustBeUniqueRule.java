package hu.unideb.nursenotes.service.imp.rules.registration.username;

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
 * This class checks if the Username is unique at the login.
 * If it is not unique, it returns a {@link Violation},
 * else it will proceed.
 */
@Component
public class UserNameMustBeUniqueRule implements Rule<User> {

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    @Override
    public final List<Violation> validate(final User request) {
        List<Violation> result = Collections.<Violation>emptyList();
        String username = request.getUserName();
        User user;
        if (username != null) {
            user = userService.findByUsername(username);
            if (user != null) {
                result = Arrays.asList(Violation.builder()
                        .vField("Username")
                        .validationMessage("Choose an other username!")
                        .build());
            }
        }
        return result;
    }
}
