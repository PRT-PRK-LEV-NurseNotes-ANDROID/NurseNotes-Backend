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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static path.register.RegisterPath.REGISTER_PATH;

/**
 * Registration REST controller class.
 */
@RestController
public class RegistrationRestController {

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * @param request registration request.
     * @return registration response.
     * @throws BaseException as exception.
     */
    @PostMapping(value = REGISTER_PATH, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registration(
            @RequestBody RegistrationRequest request) throws BaseException {
        ResponseEntity result;

        try {
            userService.save(request);
            result = ResponseEntity.accepted().
                    body("Successful registration");
        } catch (ServiceException e) {
            result = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (ViolationException e) {
            result = ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(e.getViolationList());
        }
        return result;
    }

}
