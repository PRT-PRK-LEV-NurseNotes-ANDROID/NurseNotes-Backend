package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link UserEntity} with
 * the help of {Link {@link Converter}} to UserConverter.
 */
@Component
public class UserEntityToUserConverter
        implements Converter<UserEntity, User> {

    /**
     * @param source login entity.
     * @return built user.
     */
    @Override
    public final User convert(final UserEntity source) {
        return User.builder()
                .id(source.getId())
                .userName(source.getUserName())
                .password(source.getPassword())
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .build();
    }
}
