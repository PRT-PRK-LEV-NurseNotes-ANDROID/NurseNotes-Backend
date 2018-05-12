package hu.unideb.nursenotes.service.api.validator.rule;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;

import java.util.List;

/**
 * Rule interface.
 * @param <T> for validation.
 */
public interface Rule<T> {

    /**
     * @param request validation request.
     * @return validation message.
     * @throws BaseException as an exception.
     */
    List<Violation> validate(T request) throws BaseException;
}
