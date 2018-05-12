package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.service.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class converts the {@link UserEntity} with
 * the help of {Link {@link Converter}} to UserList.
 */
@Component
public class UserEntityToUserListConverter
        implements Converter<List<UserEntity>, List<User>> {

    /**
     * User entity.
     */
    @Autowired
    private UserEntityToUserConverter userEntityToUserConverter;

    /**
     * @param source user entity.
     * @return user entity list.
     */
    @Override
    public final List<User> convert(final List<UserEntity> source) {
        return source.stream().map(user ->
                userEntityToUserConverter
                        .convert(user))
                .collect(Collectors.toList());
    }
}
