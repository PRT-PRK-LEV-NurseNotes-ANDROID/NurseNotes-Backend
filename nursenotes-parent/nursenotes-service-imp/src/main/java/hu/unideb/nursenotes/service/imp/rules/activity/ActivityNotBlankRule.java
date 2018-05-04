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

@Component
public class ActivityNotBlankRule implements Rule<Activity> {


    @Override
    public List<Violation> validate(Activity request) throws BaseException {
        return Strings.isNullOrEmpty(request.getType())
                ? Arrays.asList(Violation.builder()
                .field("Activity name")
                .validationMessage("Should not be blank!")
                .build())
                :Collections.<Violation>emptyList();
    }
}
