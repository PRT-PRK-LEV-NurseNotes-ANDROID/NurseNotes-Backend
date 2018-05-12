package hu.unideb.nursenotes.service.imp.rules.activity;

import com.google.common.base.Strings;
import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.validator.rule.Rule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This rule checks if the Activity Field is blank or not.
 * If it is blank, it will
 * return with a {@link Violation} message, else it will proceed.
 */
@Component
public class ActivityNotBlankRule implements Rule<Activity> {

    @Override
    public final List<Violation> validate(final Activity request)
            throws BaseException {
        return Strings.isNullOrEmpty(request.getType())
                ? Arrays.asList(Violation.builder()
                .vField("Activity name")
                .validationMessage("Should not be blank!")
                .build())
                : Collections.<Violation>emptyList();
    }
}
