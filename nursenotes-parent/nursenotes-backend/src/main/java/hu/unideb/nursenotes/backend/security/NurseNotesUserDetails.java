package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.Login;
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
     * Login.
     */
    private final Login login;

    /**
     * @param loginUser is the login.
     */
    public NurseNotesUserDetails(final Login loginUser) {
        super();
        this.login = loginUser;
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
}
