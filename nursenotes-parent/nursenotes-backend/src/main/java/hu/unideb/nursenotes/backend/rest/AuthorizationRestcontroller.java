package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.backend.security.SecurityContextHolderUtil;
import hu.unideb.nursenotes.commons.pojo.response.UserDetailsResponse;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import path.login.LoginPath;

@RestController
public class AuthorizationRestcontroller {

    @GetMapping(LoginPath.LOGIN_PATH)
    @PreAuthorize("isAuthenticated()")
    public UserDetailsResponse authorizeUser() {
        User user = SecurityContextHolderUtil.getUser();
        return UserDetailsResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createdDate(user.getCreatedDate())
                .build();
    }

}
