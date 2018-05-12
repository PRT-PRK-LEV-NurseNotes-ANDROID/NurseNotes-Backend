package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * Employee user details.
 */
public class NurseNotesUserDetails implements UserDetails {

    /**
     * User.
     */
    private final User user;

    /**
     * @param userUser is the user.
     */
    public NurseNotesUserDetails(final User userUser) {
        super();
        this.user = userUser;
    }

    /**
     * @return list of users.
     */
    @Override
    public final Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    /**
     * @return password.
     */
    @Override
    public final String getPassword() {
        return null;
    }

    /**
     * @return username
     */
    @Override
    public final String getUsername() {
        return null;
    }

    /**
     * @return if account is not expired.
     */
    @Override
    public final boolean isAccountNonExpired() {
        return false;
    }

    /**
     * @return if account is not locked.
     */
    @Override
    public final boolean isAccountNonLocked() {
        return false;
    }

    /**
     * @return if credentials are not expired.
     */
    @Override
    public final boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * @return if user is enabled.
     */
    @Override
    public final boolean isEnabled() {
        return false;
    }

    public User getUser() {
        return user;
    }
}
