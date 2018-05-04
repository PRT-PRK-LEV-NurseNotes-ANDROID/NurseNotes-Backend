package hu.unideb.nursenotes.service.imp.validator;

import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginValidator extends AbstractValidator<Login> {

    @Autowired
    public LoginValidator(List<Rule<Login>> rules) {
        super(rules);
    }
}
