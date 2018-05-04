package hu.unideb.nursenotes.service.imp.imp;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import hu.unideb.nursenotes.persistence.repository.LoginRepository;
import hu.unideb.nursenotes.service.api.domain.Login;
import hu.unideb.nursenotes.service.api.exception.EntityNotFoundException;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.LoginService;
import hu.unideb.nursenotes.service.imp.validator.LoginValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private LoginValidator loginValidator;

    @Override
    public Login register(Login login) throws BaseException {
        loginValidator.validate(login);
        Login convert = conversionService.convert(loginRepository.save(conversionService.convert(login, LoginEntity.class)), Login.class);
        return convert;
    }

    @Override
    public Login findByUsername(String login){
     LoginEntity loginEntity = loginRepository.findByUserName(login);
     Login convert = conversionService.convert(loginEntity, Login.class);
     return convert;
    }
}
