package hu.unideb.nursenotes.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SecurityConfiguration.class)
@ComponentScan("hu.unideb.nursenotes.backend")
public class WebConfiguration {

}
