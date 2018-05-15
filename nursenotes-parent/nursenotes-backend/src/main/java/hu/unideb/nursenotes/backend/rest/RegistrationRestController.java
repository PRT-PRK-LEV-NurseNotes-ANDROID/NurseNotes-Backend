package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static path.register.RegisterPath.REGISTER_PATH;

@RestController
public class RegistrationRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = REGISTER_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registration(@RequestBody RegistrationRequest request) throws BaseException {
        ResponseEntity result;

        try {
            userService.save(request);
            result = ResponseEntity.accepted().
                    body("Successful registration");
        } catch (ServiceException e) {
            result = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (ViolationException e) {
            result = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getViolationList());
        }
        return result;
    }

}
