package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import hu.unideb.nursenotes.persistence.repository.LoginRepository;
import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.LoginService;
import hu.unideb.nursenotes.service.imp.rules.registration.username.UserNameNotBlankRule;
import hu.unideb.nursenotes.service.imp.validator.AbstractValidator;
import hu.unideb.nursenotes.service.imp.validator.LoginValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * This class manages the users/employees.
 * This class is annotated by {@link org.springframework.stereotype.Service Service},
 * it is a more specificated {@link org.springframework.stereotype.Component Component}.
 * The {@link org.springframework.transaction.annotation.Transactional Transactional} annotation gets the transactions
 * join the existing annotations or create on if not there is no existing one.
 */

/**
 * {@link org.slf4j.Logger Logger} is needed for logging.
 */
@Slf4j
@Service
public class LoginServiceImp implements LoginService {

    /**
     * The LoginRepository derives from {@Link hu.inf.unideb.nursenotes.persistence.repository.LoginRepository} LoginRepository.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of a registration can be reached by via this data member.
     */
    @Autowired
    private LoginRepository loginRepository;

    /**
     * A service interface for type conversion. This is the entry point into the convert system.
     * Call {<T> T convert(Object source, Class<T> targetType);} to perform a thread-safe type conversion using this system.
     *
     * @author Keith Donald
     * @author Phillip Webb
     * @since 3.0
     */
    @Autowired
    private ConversionService conversionService;

    /**
     * The LoginValidator derives from the AbstractValidator class, which validates the class with the help of rules.
     */
    @Autowired
    private AbstractValidator<Login> loginValidator;

    /**
     * In this implementation, in the method with the help of {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * method, the employee is stored in the DB with a generated ID. This method returns the stored employee with its ID.
     *
     * @param login
     * @return It returns the result of the conversion via conversionService.
     *
     * @throws BaseException
     */
    @Override
    public Login register(Login login) throws BaseException {
    //    Objects.requireNonNull(login, "UserName Must Not Be Blank!");
        loginValidator.validate(login);
        log.trace(">> save: [login:{}]", login);
        Login convert = conversionService.convert(loginRepository.save(conversionService.convert(login, LoginEntity.class)), Login.class);
        log.trace("<< save: [login:{}]", login);
        return convert;
    }

    /**
     *  It returns the result of findByUsername method, that returns the desired employee by its ID from the DB.
     *  The {@Link hu.unideb.inf.nursenotes.persistence.repository.LoginRepository#findByUsername} method gives back the result.
     *
     * @param login
     * @return
     */
    @Override
    public Login findByUsername(String login){
     LoginEntity loginEntity = loginRepository.findByUserName(login);
     if(loginEntity == null)
         return null;
     else
        return conversionService.convert(loginEntity, Login.class);
    }
}
