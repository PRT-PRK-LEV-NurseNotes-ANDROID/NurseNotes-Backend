package hu.unideb.nursenotes.service.imp.config;

import hu.unideb.nursenotes.persistence.config.PersistenceConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Service configuration class.
 */
@Configuration
@Import(PersistenceConfiguration.class)
@ComponentScan("hu.unideb.nursenotes.service.imp")
public class ServiceConfiguration {
}
