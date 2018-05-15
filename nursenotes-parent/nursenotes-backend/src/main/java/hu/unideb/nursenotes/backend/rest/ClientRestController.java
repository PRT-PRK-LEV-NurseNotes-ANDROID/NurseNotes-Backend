package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.backend.security.NurseNotesUserDetails;
import hu.unideb.nursenotes.backend.security.NurseNotesUserDetailsService;
import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static path.client.ClientPath.CLIENT_PATH;

@RestController
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    /**
     * @param clientRequest is the client.
     * @return with response.
     * @throws BaseException is the exception.
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = CLIENT_PATH,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addClient(@RequestBody ClientRequest clientRequest)
            throws BaseException {

        ResponseEntity result;

        Client client = Client.builder()
                        .firstName(clientRequest.getFirstName())
                        .lastName(clientRequest.getLastName())
                        .age(clientRequest.getAge())
                        .signature(clientRequest.getFirstName() + clientRequest.getLastName())
                        .phoneNumber(clientRequest.getPhoneNumber())
                        .address(clientRequest.getAddress())
                        .wage(clientRequest.getWage())
                        .user(getUser())
                        .build();

        try {
            clientService.addClient(client);
            result = ResponseEntity.accepted().
                    body("Successful add client");
        } catch (ServiceException e) {
            result = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (ViolationException e) {
            result = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getViolationList());
        }
        return result;
    }

    private User getUser() {
        return ((NurseNotesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
}
