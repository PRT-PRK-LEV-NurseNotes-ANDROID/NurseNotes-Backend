package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.persistence.repository.UserRepository;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.service.UserService;
import hu.unideb.nursenotes.service.imp.converter.UserEntityToUserListConverter;
import hu.unideb.nursenotes.service.imp.validator.AbstractValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class manages the users/employees.
 * This class is annotated by
 * {@link org.springframework.stereotype.Service Service},
 * it is a more specified
 * {@link org.springframework.stereotype.Component Component}.
 * The {@link org.springframework.transaction.annotation
 * .Transactional Transactional} annotation gets the transactions
 * join the existing annotations or create one if there is no existing one.
 */

/**
 * {@link lombok.extern.slf4j.Slf4j Logger} is needed for logging.
 */
@Slf4j
@Service
public class UserServiceImp implements UserService {

    /**
     * The LoginRepository derives from {@link UserRepository} LoginRepository.
     * This data member is wired with the help of
     * {@link Autowired} annotation, by Spring.
     * The needful operations of a registration
     * can be reached by via this data member.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * A service interface for type conversion.
     * This is the entry point into the convert system.
     * Call {<T> T convert(Object source, Class<T> targetType);}
     * to perform a thread-safe type conversion using this system.
     *
     * @author Keith Donald
     * @author Phillip Webb
     * @since 3.0
     */
    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserEntityToUserListConverter userEntityToUserListConverter;

    /**
     * The LoginValidator derives from the AbstractValidator class,
     * which validates the class with the help of rules.
     */
    @Autowired
    private AbstractValidator<User> userValidator;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the employee is stored in the DB with a generated ID.
     * This method returns the stored employee with its ID.
     *
     * @param user is the Username of the employee.
     * @return It returns the result of the conversion via conversionService.
     * @throws BaseException
     */
    @Override
    public final User register(final User user) throws BaseException {
        //    Objects.requireNonNull(user, "UserName Must Not Be Blank!");
        userValidator.validate(user);
        log.trace(">> save: [user:{}]", user);
        User convert = conversionService
                .convert(userRepository
                                .save(conversionService
                                        .convert(user, UserEntity.class)),
                        User.class);
        log.trace("<< save: [user:{}]", user);
        return convert;
    }

    /**
     * It returns the result of findByUsername method,
     * that returns the desired employee by its ID from the DB.
     * The {@Link findByUsername} method gives back the result.
     *
     * @param user is the Username of the employee.
     * @return It returns an employee.
     */
    @Override
    public final User findByUsername(final String user) {
        UserEntity userEntity = userRepository.findByUserName(user);
        if (userEntity == null) {
            return null;
        } else {
            return conversionService.convert(userEntity, User.class);
        }
    }

    /**
     *
     * @return every user.
     */
    @Override
    public List<User> findAllUser() {
        List<UserEntity> findAllUser = userRepository.findAll();
        return userEntityToUserListConverter.convert(findAllUser);
    }
}
