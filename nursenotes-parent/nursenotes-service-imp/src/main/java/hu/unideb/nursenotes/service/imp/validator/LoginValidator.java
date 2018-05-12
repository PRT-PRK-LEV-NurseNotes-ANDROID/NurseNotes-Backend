package hu.unideb.nursenotes.service.imp.validator;

import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User validator class.
 */
@Component
public class LoginValidator extends AbstractValidator<User> {

    /**
     * @param rules of superclass.
     */
    @Autowired
    public LoginValidator(final List<Rule<User>> rules) {
        super(rules);
    }
}
