package hu.unideb.nursenotes.service.imp.converter;

import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import hu.unideb.nursenotes.service.api.domain.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class converts the {@link LoginEntity} with
 * the help of {Link {@link Converter}} to LoginList.
 */
@Component
public class LoginEntityToLoginListConverter
        implements Converter<List<LoginEntity>, List<Login>> {

    /**
     * Login entity.
     */
    @Autowired
    private LoginEntityToLoginConverter loginEntityToLoginConverter;

    /**
     * @param source login entity.
     * @return login entity list.
     */
    @Override
    public final List<Login> convert(final List<LoginEntity> source) {
        return source.stream().map(login ->
                loginEntityToLoginConverter
                        .convert(login))
                .collect(Collectors.toList());
    }
}
