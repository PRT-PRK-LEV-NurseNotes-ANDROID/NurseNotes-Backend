package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static path.client.ClientPath.CLIENT_PATH;

/**
 * Client rest controller class.
 */
@RestController
public class ClientRestController {

    /**
     * Client service.
     */
    @Autowired
    private ClientService clientService;

    /**
     * @param client is the client.
     * @return with response.
     * @throws BaseException is the exception.
     */
    @RequestMapping(path = CLIENT_PATH, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public final ResponseEntity addClient(@RequestBody final Client client)
            throws BaseException {

        ResponseEntity responseEntity;

        try {
            clientService.addClient(client);
            responseEntity = ResponseEntity.accepted()
                    .body("Successful client insertion");
        } catch (ServiceException e) {
            responseEntity = ResponseEntity.status(HttpStatus
                    .INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
        return responseEntity;
    }
}
