package hu.unideb.nursenotes.backend.config;

import hu.unideb.nursenotes.persistence.config.PersistenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * Spring component lombok.
 */
@SpringBootApplication
@Import({PersistenceConfiguration.class, WebConfiguration.class})
public class Application extends SpringBootServletInitializer {

    /**
     * Main class of Nurse Notes backend.
     *
     * @param args are the arguments.
     */
    public static void main(final String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(
            final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
