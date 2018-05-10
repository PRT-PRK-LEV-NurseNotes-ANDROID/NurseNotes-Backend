package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.LoginService;
import hu.unideb.nursenotes.service.imp.rules.registration.username.UserNameNotBlankRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Objects;

import static path.register.RegisterPath.REGISTER_PATH;

@RestController
public class RegistrationRestController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = REGISTER_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody Login login) throws BaseException {
        ResponseEntity responseEntity;

        try {
            loginService.register(login);
            responseEntity = ResponseEntity.accepted().body("Successful registration");
        } catch (ServiceException e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (ViolationException e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getViolationList());
        }
            return responseEntity;
        }
    @GetMapping("/login")
    @PreAuthorize("hasRole('USER')")
    public String hello() {
        return "hello";
    }
}
