package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * User converter class.
 */
@Component
public class UserToUserEntityConverter implements Converter<User, UserEntity> {

    /**
     * User converter.
     *
     * @param user to be converted.
     * @return user entity.
     */
    @Override
    public UserEntity convert(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createdDate(user.getCreatedDate())
                .build();
    }
}
