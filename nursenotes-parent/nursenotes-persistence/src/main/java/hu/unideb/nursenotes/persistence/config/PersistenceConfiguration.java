package hu.unideb.nursenotes.persistence.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Persistence configuration class.
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages =
        "hu.unideb.nursenotes.persistence.repository")
@EntityScan(basePackages = "hu.unideb.nursenotes.persistence.entity")
public class PersistenceConfiguration {
}
