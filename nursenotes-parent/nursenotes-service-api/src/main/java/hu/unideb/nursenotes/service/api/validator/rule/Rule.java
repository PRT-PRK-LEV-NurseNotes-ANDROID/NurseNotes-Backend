package hu.unideb.nursenotes.service.api.validator.rule;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;

import java.util.List;

public interface Rule<T> {

    List<Violation> validate(T request) throws BaseException;
}
