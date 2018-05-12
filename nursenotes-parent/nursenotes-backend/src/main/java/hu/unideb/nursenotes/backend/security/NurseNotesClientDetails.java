package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class NurseNotesClientDetails implements UserDetails {

    /**
     * User.
     */
    private final Client client;

    /**
     * @param client is the Client.
     */
    public NurseNotesClientDetails(final Client client) {
        super();
        this.client = client;
    }

    /**
     * @return list of clients.
     */
    @Override
    public final Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("CLIENT"));
    }

    /**
     * @return password.
     */
    @Override
    public final String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    /**
     * @return username
     */
   // @Override
    public final String getFirstname() {
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

    public Client getClient() {
        return client;
    }

}
