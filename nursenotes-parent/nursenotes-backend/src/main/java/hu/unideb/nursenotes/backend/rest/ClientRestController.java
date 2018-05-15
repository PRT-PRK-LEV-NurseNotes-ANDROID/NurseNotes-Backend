package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.exceptions.ViolationException;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static path.client.ClientPath.CLIENT_PATH;

@RestController
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    /**
     * @param client is the client.
     * @return with response.
     * @throws BaseException is the exception.
     */
    @RequestMapping(path = CLIENT_PATH, method = org.springframework.web.bind.annotation.RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public final ResponseEntity addClient(@RequestBody ClientRequest client)
            throws BaseException {

        ResponseEntity result;

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
}
