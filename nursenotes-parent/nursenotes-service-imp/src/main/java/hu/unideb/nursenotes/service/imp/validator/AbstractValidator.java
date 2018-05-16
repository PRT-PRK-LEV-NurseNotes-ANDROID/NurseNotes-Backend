package hu.unideb.nursenotes.service.imp.validator;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * Generic validator for requests.
 *
 * @param <T>
 *            validated request type.
 */
@Slf4j
public class AbstractValidator<T> {

    @Autowired
    private List<Rule<T>> rules;

    /**
     * Abstract validator.
     * @param rules the rules.
     */
    public AbstractValidator(List<Rule<T>> rules) {
        super();
        this.rules = rules;
    }

    /**
     * Validates request.
     *
     * @param request request to be validated.
     * @throws BaseException as exception.
     */
    public void validate(T request) throws BaseException {
        List<Violation> violations = new LinkedList<>();
        for (Rule<T> rule : rules) {
            log.trace("Executing {} rule.", rule.getClass().getSimpleName());
            violations.addAll(rule.validate(request));
        }
        if (!violations.isEmpty()) {
            throw new ViolationException(violations);
        }
    }

}
