package hu.unideb.nursenotes.service.imp.rules.client.name;

import com.google.common.base.Strings;
import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class checks if the Client name is blank or not.
 * If it is blank, it returns with a {@link Violation} message,
 * else it will proceed.
 */
@Component
public class ClientNameNotBlankRule implements Rule<Client> {
    @Override
    public final List<Violation> validate(Client request)
            throws BaseException {
        return Strings.isNullOrEmpty(request.getFirstName()
                + " " + request.getLastName())
                ? Arrays.asList(Violation.builder()
                .field("Client name")
                .validationMessage("Should not be blank!")
                .build())
                : Collections.<Violation>emptyList();
    }

}
