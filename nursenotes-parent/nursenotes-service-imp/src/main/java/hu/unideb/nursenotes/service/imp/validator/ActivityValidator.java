package hu.unideb.nursenotes.service.imp.validator;

import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Activity validator class.
 */
@Component
public class ActivityValidator extends AbstractValidator<Activity> {

    /**
     * @param rules of superclass.
     */
    @Autowired
    public ActivityValidator(List<Rule<Activity>> rules) {
        super(rules);
    }
}
