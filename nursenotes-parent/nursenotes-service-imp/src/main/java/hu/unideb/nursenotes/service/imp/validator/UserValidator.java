package hu.unideb.nursenotes.service.imp.validator;

import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User validator class.
 */
@Component
public class UserValidator extends AbstractValidator<RegistrationRequest> {

    /**
     * @param rules of superclass.
     */
    @Autowired
    public UserValidator(List<Rule<RegistrationRequest>> rules) {
        super(rules);
    }
}
