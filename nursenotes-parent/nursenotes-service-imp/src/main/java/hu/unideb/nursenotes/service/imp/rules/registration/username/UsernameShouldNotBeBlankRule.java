package hu.unideb.nursenotes.service.imp.rules.registration.username;

import com.google.common.base.Strings;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Validates username not to be blank.
 */
@Component
public class UsernameShouldNotBeBlankRule implements Rule<RegistrationRequest> {

    @Override
    public List<Violation> validate(RegistrationRequest request) {
        return Strings.isNullOrEmpty(request.getUsername()) ?
                Arrays.asList(Violation.builder()
                        .field("username")
                        .validationMessage("blank rule")
                        .build()) :
                Collections.<Violation>emptyList();
    }
}
