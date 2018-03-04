package hu.unideb.nursenotes.backend.config;

import hu.unideb.nursenotes.persistence.config.PersistenceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfiguration.class,SecurityConfiguration.class})
@ComponentScan("hu.unideb.nursenotes.backend")
public class WebConfiguration {

}
