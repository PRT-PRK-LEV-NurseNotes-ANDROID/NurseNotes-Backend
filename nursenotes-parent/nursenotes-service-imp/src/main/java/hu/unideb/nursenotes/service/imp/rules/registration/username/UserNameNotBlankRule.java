package hu.unideb.nursenotes.service.imp.rules.registration.username;

import com.google.common.base.Strings;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserNameNotBlankRule implements Rule<Login> {
    @Override
    public List<Violation> validate(Login request) {
        return Strings.isNullOrEmpty(request.getUserName()) ?
                Arrays.asList(Violation.builder()
                        .field("Username")
                        .validationMessage("Cannot be blank!")
                        .build()) :
                Collections.<Violation>emptyList();
    }
}
