package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import hu.unideb.nursenotes.service.api.domain.Login;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LoginToLoginEntityConverter implements Converter<Login, LoginEntity> {
    @Override
    public LoginEntity convert(Login source) {
        return LoginEntity.builder()
                .id(source.getId())
                .userName(source.getUserName())
                .password(source.getPassword())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .build();
    }
}
