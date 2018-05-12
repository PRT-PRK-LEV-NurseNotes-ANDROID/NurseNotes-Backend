package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import hu.unideb.nursenotes.service.api.domain.Login;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link Login} with
 * the help of {Link {@link Converter}} to {@link LoginEntity}.
 */
@Component
public class LoginToLoginEntityConverter
        implements Converter<Login, LoginEntity> {

    /**
     * @param source login.
     * @return login entity.
     */
    @Override
    public final LoginEntity convert(final Login source) {
        return LoginEntity.builder()
                .logId(source.getId())
                .logUserName(source.getUserName())
                .logPassword(source.getPassword())
                .logFirstName(source.getFirstName())
                .logLastName(source.getLastName())
                .logEmail(source.getEmail())
                .build();
    }
}
