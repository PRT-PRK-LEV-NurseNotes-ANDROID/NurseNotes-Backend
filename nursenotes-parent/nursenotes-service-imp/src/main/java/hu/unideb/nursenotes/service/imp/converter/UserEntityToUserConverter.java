package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * User converter class.
 */
@Component
public class UserEntityToUserConverter implements Converter<UserEntity, User> {

    /**
     * User converter.
     *
     * @param userEntity to be converted.
     * @return user domain.
     */
    @Override
    public User convert(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .createdDate(userEntity.getCreatedDate())
                .build();
    }
}
