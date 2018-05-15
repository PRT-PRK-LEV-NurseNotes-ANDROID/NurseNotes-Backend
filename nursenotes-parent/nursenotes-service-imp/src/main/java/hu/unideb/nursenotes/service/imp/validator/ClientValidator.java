package hu.unideb.nursenotes.service.imp.validator;

import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Client validator class.
 */
@Component
public class ClientValidator extends AbstractValidator<ClientRequest> {

    /**
     * @param rules of superclass.
     */
    @Autowired
    public ClientValidator(final List<Rule<ClientRequest>> rules) {
        super(rules);
    }
}
