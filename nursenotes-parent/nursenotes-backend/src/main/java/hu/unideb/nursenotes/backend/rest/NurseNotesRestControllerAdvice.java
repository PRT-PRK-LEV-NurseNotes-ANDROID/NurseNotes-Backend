package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.commons.pojo.validator.ViolationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Nurse Notes REST controller.
 */
@RestControllerAdvice
public class NurseNotesRestControllerAdvice {

    /**
     * Message source.
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * @param violation the violation.
     * @return Response entity.
     */
    @ExceptionHandler(ViolationException.class)
    public ResponseEntity<ViolationResponse> handleValidationException(
            ViolationException violation) {

        /**
         * Violation list.
         */
        List<Violation> translatedViolationList = new LinkedList<>();

        violation.getViolationList().forEach(violation1 -> {

            String message = messageSource.getMessage(
                    violation1.getValidationMessage(), null, null);
            translatedViolationList.add(Violation.builder()
                    .field(violation1.getField())
                    .validationMessage(message)
                    .build());
        });

        return ResponseEntity.badRequest()
                .body(ViolationResponse.builder()
                        .violationList(translatedViolationList)
                        .build());
    }

    /**
     * @param exception is base exception.
     * @return response.
     * @throws ViolationException as exception.
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ViolationResponse> handleBaseException(
            BaseException exception) throws ViolationException {
        if (exception instanceof ViolationException) {
            throw (ViolationException) exception;
        }

        Violation violation = Violation.builder().field("base").
                validationMessage(exception.getMessage()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ViolationResponse.builder()
                        .violationList(Arrays.asList(violation))
                        .build());
    }
}
