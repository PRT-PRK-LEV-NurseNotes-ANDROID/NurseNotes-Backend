package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NurseNotesClientDetailsService implements UserDetailsService {

    /**
     * User login service.
     */
    @Autowired
    private ClientService clientService;

    /**
     * @param nurseNotesClientName clients.
     * @return client details.
     */
    @Override
    public final UserDetails loadUserByUsername(
            final String nurseNotesClientName) {
        Client client = clientService.findByName(nurseNotesClientName);

        if (client == null) {
            throw new UsernameNotFoundException("Client name was not found.");
        }
        return new NurseNotesClientDetails(client);
    }

}
