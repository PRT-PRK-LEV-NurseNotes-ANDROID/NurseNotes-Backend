package hu.unideb.nursenotes.service.api.validator.rule;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;

import java.util.List;

/**
 * Rule created for Validators.
 *
 * @param <T> list/type of rules.
 */
public interface Rule<T> {

    /**
     * Validates request.
     *
     * @param request request to be validated.
     * @return violation list if the request does not fit the rule.
     * @throws BaseException as exception.
     */
    List<Violation> validate(T request) throws BaseException;
}
