package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import hu.unideb.nursenotes.service.api.service.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static path.history.HistoryPath.HISTORY_PATH;

/**
 * History rest controller class.
 */
@Data
@RestController
public class HistoryRestController {

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
     * @param client is the client.
     * @return response.
     */
    @RequestMapping(path = HISTORY_PATH, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public final ResponseEntity history(@RequestBody final Client client) {
        ResponseEntity responseEntity;

        clientService.findAllClient();
        responseEntity = ResponseEntity.accepted()
                .body("ClientList");
        return responseEntity;
    }
}
