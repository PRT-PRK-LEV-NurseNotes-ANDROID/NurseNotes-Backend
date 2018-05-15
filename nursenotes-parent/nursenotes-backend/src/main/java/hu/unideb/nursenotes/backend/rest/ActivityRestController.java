package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.backend.security.NurseNotesUserDetails;
import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.ActivityRequest;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static path.PathContainer.CLIENT_ID;
import static path.PathContainer.PARAM_CLIENT_ID;
import static path.activity.ActivityPath.ACTIVITY_PATH;

@RestController
public class ActivityRestController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ClientService clientService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = ACTIVITY_PATH + CLIENT_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addActivity(@RequestBody ActivityRequest activityRequest, @PathVariable(PARAM_CLIENT_ID) Long clientId)  throws BaseException {

        ResponseEntity result;

        Client client = clientService.findClientById(clientId);

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

}