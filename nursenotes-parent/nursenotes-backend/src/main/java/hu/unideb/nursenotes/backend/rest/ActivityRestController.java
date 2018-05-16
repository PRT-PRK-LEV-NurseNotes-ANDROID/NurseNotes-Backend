package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.ActivityRequest;
import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static path.PathContainer.CLIENT_ID;
import static path.PathContainer.PARAM_CLIENT_ID;
import static path.activity.ActivityPath.ACTIVITY_PATH;

/**
 * Activity REST Controller class.
 */
@RestController
public class ActivityRestController {

    /**
     * Activity service.
     */
    @Autowired
    private ActivityService activityService;

    /**
     * Client service.
     */
    @Autowired
    private ClientService clientService;

    /**
     * @param activityRequest requested activity.
     * @param clientId        the ID of the client.
     * @return Added activity response.
     * @throws BaseException as exception.
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = ACTIVITY_PATH + CLIENT_ID, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addActivity(
            @RequestBody ActivityRequest activityRequest,
            @PathVariable(PARAM_CLIENT_ID) Long clientId) throws BaseException {

        ResponseEntity result;

        Client client = clientService.findClientById(clientId);

        /**
         * Activity builder.
         */
        Activity activity = Activity.builder()
                .travelTime(activityRequest.getTravelTime())
                .timeSpent(activityRequest.getTimeSpent())
                .type(activityRequest.getType())
                .date(activityRequest.getDate())
                .client(client)
                .build();

        try {
            activityService.addActivity(activity);
            result = ResponseEntity.accepted().
                    body("Successful add activity");
        } catch (ServiceException e) {
            result = ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return result;
    }

    /**
     * @param clientId the ID of the client.
     * @return The list of accepted activity list.
     * @throws BaseException as exception.
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = ACTIVITY_PATH + CLIENT_ID)
    public ResponseEntity getAllActivityByClient(
            @PathVariable(PARAM_CLIENT_ID) Long clientId) throws BaseException {
        Client client = clientService.findClientById(clientId);

        List<ActivityResponse> allActivityByClient =
                activityService.getAllActivityByClient(client);
        return ResponseEntity.accepted().body(allActivityByClient);
    }

}
