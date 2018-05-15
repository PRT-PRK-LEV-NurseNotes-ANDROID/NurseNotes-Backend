package hu.unideb.nursenotes.backend.security;

import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;


public class SecurityContextHolderUtil {

    private SecurityContextHolderUtil() {
        super();
    }

    public static long getUserId() {
        return getUser().getId().longValue();
    }

    public static Long getUserIdIfExsistOrReturnNull() {
        if (isNurseNotesUserDetails() && Objects.nonNull(getUser()) && Objects.nonNull(getUser().getId())) {
            return getUser().getId().longValue();
        } else {
            return null;
        }
    }

    public static User getUser() {
        return ((NurseNotesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

    public static boolean isNurseNotesUserDetails() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof NurseNotesUserDetails;
    }

}
