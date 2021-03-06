package hu.unideb.nursenotes.service.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages =
        "hu.unideb.nursenotes.persistence.repository")
@EntityScan(basePackages = "hu.unideb.nursenotes.persistence.entity")
public class TestPersistenceConfiguration {
}
