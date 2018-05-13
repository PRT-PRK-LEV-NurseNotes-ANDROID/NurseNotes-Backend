package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static path.login.LoginPath.LOGIN_PATH;
import static path.register.RegisterPath.REGISTER_PATH;

/**
 * Registration rest controller class.
 */
@RestController
public class RegistrationRestController {

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * @param user is the employee.
     * @return response.
     * @throws BaseException is the exception.
     */
    @RequestMapping(path = REGISTER_PATH, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public final ResponseEntity register(@RequestBody final User user)
            throws BaseException {
        ResponseEntity responseEntity;

        try {
            userService.register(user);
            responseEntity = ResponseEntity.accepted().
                    body("Successful registration");
        } catch (ServiceException e) {
            responseEntity = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (ViolationException e) {
            responseEntity = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getViolationList());
        }
        return responseEntity;
    }

    /**
     * @return login response.
     */
    @GetMapping("/login")
    @PreAuthorize("hasRole('USER')")
    public final String hello() {
        return "hello";
    }
}

