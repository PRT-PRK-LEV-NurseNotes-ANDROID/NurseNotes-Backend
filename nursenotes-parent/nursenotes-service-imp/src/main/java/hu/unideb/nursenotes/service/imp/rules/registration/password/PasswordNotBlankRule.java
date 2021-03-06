package hu.unideb.nursenotes.service.imp.rules.registration.password;

import com.google.common.base.Strings;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Validates password should not be blank.
 */
@Component
public class PasswordNotBlankRule implements Rule<RegistrationRequest> {

    @Override
    public List<Violation> validate(RegistrationRequest request) {
        return Strings.isNullOrEmpty(request.getPassword()) ?
                Arrays.asList(Violation.builder()
                        .field("password")
                        .validationMessage("blank rule")
                        .build()) :
                Collections.<Violation>emptyList();
    }
}
