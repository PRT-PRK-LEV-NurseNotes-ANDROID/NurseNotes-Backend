package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import hu.unideb.nursenotes.service.api.domain.Login;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link LoginEntity} with
 * the help of {Link {@link Converter}} to LoginConverter.
 */
@Component
public class LoginEntityToLoginConverter
        implements Converter<LoginEntity, Login> {

    /**
     * @param source login entity.
     * @return built login.
     */
    @Override
    public final Login convert(final LoginEntity source) {
        return Login.builder()
                .id(source.getId())
                .userName(source.getUserName())
                .password(source.getPassword())
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .build();
    }
}
