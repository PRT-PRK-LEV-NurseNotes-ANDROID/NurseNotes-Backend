package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import hu.unideb.nursenotes.service.api.domain.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoginEntityToLoginListConverter implements Converter<List<LoginEntity>, List<Login>> {

    @Autowired
    private LoginEntityToLoginConverter loginEntityToLoginConverter;

    @Override
    public List<Login> convert(List<LoginEntity> source){
        return source.stream().map(login -> loginEntityToLoginConverter.convert(login)).collect(Collectors.toList());
    }
}