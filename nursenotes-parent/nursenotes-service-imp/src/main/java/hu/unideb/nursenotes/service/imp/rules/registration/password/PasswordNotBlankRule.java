package hu.unideb.nursenotes.service.imp.rules.registration.password;

import com.google.common.base.Strings;
import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class PasswordNotBlankRule implements Rule<Login> {
    @Override
    public List<Violation> validate(Login request) throws BaseException {
        return Strings.isNullOrEmpty(request.getPassword()) ?
                Arrays.asList(Violation.builder()
                        .field("Password")
                        .validationMessage("Cannot be blank!")
                        .build()) :
        Collections.<Violation>emptyList();
    }
}
