package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This class converts the {@link User} with
 * the help of {Link {@link Converter}} to {@link UserEntity}.
 */
@Component
public class UserToUserEntityConverter
        implements Converter<User, UserEntity> {

    /**
     * @param source user.
     * @return user entity.
     */
    @Override
    public final UserEntity convert(final User source) {
        return UserEntity.builder()
                .logId(source.getId())
                .logUserName(source.getUserName())
                .logPassword(source.getPassword())
                .logFirstName(source.getFirstName())
                .logLastName(source.getLastName())
                .logEmail(source.getEmail())
                .build();
    }
}