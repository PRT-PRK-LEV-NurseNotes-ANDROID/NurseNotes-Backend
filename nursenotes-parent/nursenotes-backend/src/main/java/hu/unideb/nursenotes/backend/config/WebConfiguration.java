package hu.unideb.nursenotes.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hu.unideb.nursenotes.service.imp.config.ServiceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Web configuration class.
 */
@Configuration
@Import({ServiceConfiguration.class, SecurityConfiguration.class})
@ComponentScan("hu.unideb.nursenotes.backend")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    /**
     * @param converters message converter.
     */
    @Override
    public final void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }

    /**
     * @return mapped object.
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .enable(SerializationFeature.INDENT_OUTPUT)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    /**
     * @return converted object mapper.
     */
    @Bean
    public MappingJackson2HttpMessageConverter
    mappingJackson2HttpMessageConverter() {

        return new MappingJackson2HttpMessageConverter(objectMapper());
    }

}
