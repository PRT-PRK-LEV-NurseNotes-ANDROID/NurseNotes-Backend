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
 * Abstract validator class.
 * @param <T> validator.
 */
@Slf4j
public class AbstractValidator<T> {

    /**
     * List of rules.
     */
    @Autowired
    private List<Rule<T>> rules;

    /**
     * Abstract validator list.
     * @param absRules of validator.
     */
    public AbstractValidator(final List<Rule<T>> absRules) {
        super();
        this.rules = absRules;
    }

    /**
     * Validation.
     * @param request of validation.
     * @throws BaseException as the exception.
     */
    public final void validate(final T request)
            throws BaseException {
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
