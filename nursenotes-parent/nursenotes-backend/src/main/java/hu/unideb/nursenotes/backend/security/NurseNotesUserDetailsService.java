package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Nurse notes user details service class.
 */
@Service
public class NurseNotesUserDetailsService implements UserDetailsService {

    /**
     * User login service.
     */
    @Autowired
    private UserService userService;

    /**
     * @param nurseNoteLoginName user login name.
     * @return user details.
     */
    @Override
    public final UserDetails loadUserByUsername(
            final String nurseNoteLoginName) {
        User user = userService.findByUsername(nurseNoteLoginName);

        if (user == null) {
            throw new UsernameNotFoundException("User was not found.");
        }
        return new NurseNotesUserDetails(user);
    }
}
