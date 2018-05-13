package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.backend.security.NurseNotesClientDetails;
import hu.unideb.nursenotes.backend.security.NurseNotesUserDetails;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.commons.pojo.response.ClientListResponse;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.service.ClientService;
import hu.unideb.nursenotes.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static path.home.HomePath.HOME_PATH;

/**
 * Home rest controller.
 */
@RestController
public class HomeRestController {

    /**
     * Client service.
     */
    @Autowired
    private ClientService clientService;

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * @param client is the client.
     * @return response.
     */
    @RequestMapping(path = HOME_PATH, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public final ResponseEntity home(@RequestBody final Client client) {
        ResponseEntity responseEntity;

//        clientService.findByUser(getUser());
        responseEntity = ResponseEntity.accepted()
                .body("Successful registration");
        return responseEntity;
    }

//    @PreAuthorize("isAuthenticated()")
//    @GetMapping(path = HOME_PATH)
//    public ResponseEntity<?> findClient() throws ViolationException {
//        List<Client> clientByUser = clientService.findByUser(getUser());
//        return ResponseEntity.accepted().body(new ClientListResponse(clientByUser));
//    }

    private User getUser() {
        return ((NurseNotesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

}
