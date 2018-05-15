package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class NurseNotesUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user;
        try {
            user = userService.findByUsername(username);
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        } catch (BaseException e) {
            throw new AuthenticationServiceException("Error on authenticating internal user.", e);
        }
        return new NuresNotesUserDetails(user);
    }
}
