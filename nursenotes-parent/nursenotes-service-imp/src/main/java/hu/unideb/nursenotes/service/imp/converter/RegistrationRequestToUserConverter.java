package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RegistrationRequestToUserConverter implements Converter<RegistrationRequest, User> {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Override
    public User convert(RegistrationRequest source) {
        if (source == null) {
            return null;
        }
        return User.builder()
                .username(source.getUsername())
                .email(source.getEmail())
                .password(PASSWORD_ENCODER.encode(source.getPassword()))
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .createdDate(LocalDate.now())
                .build();
    }
}


