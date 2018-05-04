package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NurseNotesUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String nurseNoteLoginName) {
        Login login = loginService.findByUsername(nurseNoteLoginName);

        if (login == null){
            throw new UsernameNotFoundException("User was not found.");
        }
        return new NurseNotesUserDetails(login);
    }
}
