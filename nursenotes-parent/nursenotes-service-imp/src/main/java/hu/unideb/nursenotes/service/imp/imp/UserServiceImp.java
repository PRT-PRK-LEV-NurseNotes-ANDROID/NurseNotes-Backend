package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.persistence.entity.UserEntity;
import hu.unideb.nursenotes.persistence.repository.UserRepository;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.UserService;
import hu.unideb.nursenotes.service.imp.validator.AbstractValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

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

    private static final String REGISTRATION_REQUEST_CAN_NOT_BE_NULL = "Registration request can not be NULL.";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AbstractValidator<RegistrationRequest> registrationRequestValidator;

    @Override
    public User findByUsername(String username) throws BaseException {
        log.trace(">> findByUsername: [username:{}]", username);
        if (StringUtils.isBlank(username)) {
            throw new ServiceException("username is blank");
        }
        UserEntity userEntity;
        try {
            userEntity = userRepository.findByUsername(username);
        } catch (Exception e) {
            String errorMsg = String.format("Error on finding user by username:%s", username);
            throw new ServiceException(errorMsg, e);
        }
        if (Objects.isNull(userEntity)) {
            String errorMsg = String.format("User with username:%s not found.", username);
            throw new EntityNotFoundException(errorMsg);
        }
        User convert = conversionService.convert(userEntity, User.class);
        log.trace("<< findByUsername: [username:{}]", username);
        return convert;
    }

    @Override
    public User save(RegistrationRequest registrationRequest) throws BaseException {
        Objects.requireNonNull(registrationRequest, REGISTRATION_REQUEST_CAN_NOT_BE_NULL);
        log.trace(">> save: [user:{}]", registrationRequest);
        registrationRequestValidator.validate(registrationRequest);
        User convert = conversionService.convert(registrationRequest, User.class);
        UserEntity userEntity = conversionService.convert(convert, UserEntity.class);
        userRepository.save(userEntity);
        log.trace("<< save: [user:{}]", registrationRequest);
        return convert;
    }

}
