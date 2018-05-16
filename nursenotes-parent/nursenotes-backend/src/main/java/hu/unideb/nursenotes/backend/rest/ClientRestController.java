package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.backend.security.NurseNotesUserDetails;
import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.api.service.ClientService;
import hu.unideb.nursenotes.service.imp.converter.ActivityEntityListToActivityListConverter;
import hu.unideb.nursenotes.service.imp.converter.ActivityListToActivityEntityListConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static path.PathContainer.CLIENT_ID;
import static path.PathContainer.PARAM_CLIENT_ID;
import static path.client.ClientPath.CLIENT_PATH;

/**
 * Client REST controller class.
 */
@RestController
public class ClientRestController {

    /**
     * Client service.
     */
    @Autowired
    private ClientService clientService;

    /**
     * Activity service.
     */
    @Autowired
    private ActivityService activityService;

    /**
     * Activity list converter.
     */
    @Autowired
    private ActivityListToActivityEntityListConverter
            activityListToActivityEntityListConverter;

    /**
     * Activity entity converter.
     */
    @Autowired
    private ActivityEntityListToActivityListConverter
            activityEntityListToActivityListConverter;

    /**
     * @param clientRequest is the client.
     * @return with response.
     * @throws BaseException is the exception.
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = CLIENT_PATH, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addClient(
            @RequestBody ClientRequest clientRequest)
            throws BaseException {

        ResponseEntity result;

        /**
         * Client builder.
         */
        Client client = Client.builder()
                .firstName(clientRequest.getFirstName())
                .lastName(clientRequest.getLastName())
                .age(clientRequest.getAge())
                .signature(clientRequest
                        .getFirstName() + clientRequest.getLastName())
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
        }
        return result;
    }

    /**
     * @param clientRequest is the request.
     * @param clientId      is the ID of client.
     * @return response entity.
     * @throws BaseException as exception.
     */
    @PreAuthorize("isAuthenticated()")
    @PutMapping(path = CLIENT_PATH + CLIENT_ID)
    public ResponseEntity<?> putClient(@RequestBody ClientRequest clientRequest,
                                       @PathVariable(PARAM_CLIENT_ID) Long clientId)
            throws BaseException {
        if (Objects.isNull(clientRequest)) {
            return ResponseEntity.badRequest().body("null");
        }

        Client client = clientService.findClientById(clientId);

        Client clientModified = Client.builder()
                .id(clientId)
                .firstName(clientRequest.getFirstName())
                .lastName(clientRequest.getLastName())
                .age(clientRequest.getAge())
                .signature(clientRequest.
                        getFirstName() + clientRequest.getLastName())
                .phoneNumber(clientRequest.getPhoneNumber())
                .address(clientRequest.getAddress())
                .wage(clientRequest.getWage())
                .user(client.getUser())
                .build();

        clientService.updateClient(clientModified);
        return ResponseEntity.accepted().body("Success");
    }

    /**
     * @return response entity list.
     * @throws BaseException as exception.
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = CLIENT_PATH)
    public ResponseEntity<?> getAllClient() throws BaseException {
        List<ClientResponse> clientByUser = clientService.
                findUsersClient(getUser());
        return ResponseEntity.accepted().body(clientByUser);
    }

    /**
     * @return user.
     */
    private User getUser() {
        return ((NurseNotesUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUser();
    }
}
