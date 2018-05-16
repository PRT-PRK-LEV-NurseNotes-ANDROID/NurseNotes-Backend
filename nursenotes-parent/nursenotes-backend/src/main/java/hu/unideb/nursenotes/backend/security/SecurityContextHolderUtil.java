package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

/**
 * Security Context holder class.
 */
public class SecurityContextHolderUtil {

    /**
     * Class empty constructor.
     */
    private SecurityContextHolderUtil() {
        super();
    }

    /**
     * @return user ID.
     */
    public static long getUserId() {

        return getUser().getId().longValue();
    }

    /**
     * @return not empty user ID.
     */
    public static Long getUserIdIfExsistOrReturnNull() {
        if (isNurseNotesUserDetails() && Objects.
                nonNull(getUser()) && Objects.
                nonNull(getUser().getId())) {
            return getUser().getId().longValue();
        } else {
            return null;
        }
    }

    /**
     * @return user.
     */
    public static User getUser() {
        return ((NurseNotesUserDetails) SecurityContextHolder
                .getContext().getAuthentication()
                .getPrincipal()).getUser();
    }

    /**
     * @return authenticated user.
     */
    public static boolean isNurseNotesUserDetails() {
        return SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()
                instanceof NurseNotesUserDetails;
    }

}
