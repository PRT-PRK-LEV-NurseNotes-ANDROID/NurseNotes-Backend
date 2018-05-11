package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static path.home.HomePath.HOME_PATH;

@RestController
public class HomeRestController {

    @Autowired
    ClientService clientService;

    @RequestMapping(path = HOME_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity home(@RequestBody Client client){
        ResponseEntity responseEntity;

        clientService.findAllClient();
        responseEntity = ResponseEntity.accepted().body("Successful registration");
        return responseEntity;
    }
}
