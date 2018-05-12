package hu.unideb.nursenotes.service.config;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.stereotype.Component;

import javax.naming.NamingException;
import java.util.Set;
import org.reflections.Reflections;


@Configuration
@Import({TestPersistenceConfiguration.class,})
@ComponentScan("hu.unideb.nursenotes")
public class TestConfiguration {

    protected static final String CONVERTER_PACKAGE = "hu.unideb.nursenotes.service.imp.converter";

    @Bean
    public ConversionService conversionService() {
        Reflections reflections = new Reflections(CONVERTER_PACKAGE);
        Set<Class<?>> converters = reflections.getTypesAnnotatedWith(Component.class);
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        for (Class<?> converter : converters) {
            try {
                defaultConversionService.addConverter((Converter<?, ?>) converter.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return defaultConversionService;
    }

    @Bean(initMethod = "emptyActivatedContextBuilder")
    public SimpleNamingContextBuilder simpleNamingContextBuilder() {
        SimpleNamingContextBuilder simpleNamingContextBuilder = new SimpleNamingContextBuilder();
        try {
            simpleNamingContextBuilder.activate();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return simpleNamingContextBuilder;
    }

}
