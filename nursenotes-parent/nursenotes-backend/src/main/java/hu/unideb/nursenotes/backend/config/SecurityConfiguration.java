package hu.unideb.nursenotes.backend.config;

import hu.unideb.nursenotes.backend.security.NurseNotesUserDetailsService;
import hu.unideb.nursenotes.backend.security.common.OAuthAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.LinkedHashMap;

/**
 * Security configuration class.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration
        extends WebSecurityConfigurerAdapter {

    /**
     * Basic authority realm name.
     */
    private static final String BASIC_AUTH_REALM_NAME = "nursenotes";

    /**
     * Login path.
     */
    private static final String LOGIN_FORM_PATH = "/login";

    /**
     * Rest controller path.
     */
    private static final String REST_PATH_PREFIX = "/rest/**";

    /**
     * @param http configuration.
     * @throws Exception as exception.
     */
    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .clearAuthentication(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(
                        delegatingAuthenticationEntryPoint());

        http.httpBasic();
    }

    /**
     * @return Basic authentication filter.
     * @throws Exception as excepton.
     */
    @Bean
    public BasicAuthenticationFilter basicAuthenticationFilter()
            throws Exception {
        return new BasicAuthenticationFilter(authenticationManager(),
                delegatingAuthenticationEntryPoint());
    }

    /**
     * @param auth user details.
     * @throws Exception as exception.
     */
    @Autowired
    public final void configureGlobal(
            final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService()).
                passwordEncoder(passwordEncoder());
    }

    /**
     * @return encrypted password.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /**
     * @return authentication entry point.
     */
    @Bean
    public AuthenticationEntryPoint delegatingAuthenticationEntryPoint() {
        DelegatingAuthenticationEntryPoint
                delegatingAuthenticationEntryPoint =
                new DelegatingAuthenticationEntryPoint(entryPoints());
        delegatingAuthenticationEntryPoint.setDefaultEntryPoint(
                loginUrlAuthenticationEntryPoint());
        return delegatingAuthenticationEntryPoint;
    }

    /**
     * @return basic authentication entry point.
     */
    @Bean
    public AuthenticationEntryPoint basicAuthenticationEntryPoint() {
        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint =
                new BasicAuthenticationEntryPoint();
        basicAuthenticationEntryPoint.setRealmName(BASIC_AUTH_REALM_NAME);
        return basicAuthenticationEntryPoint;
    }

    /**
     * @return url authentication.
     */
    @Bean
    public AuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint(LOGIN_FORM_PATH);
    }

    /**
     * @return basic authentication request matcher.
     */
    @Bean
    public RequestMatcher basicAuthenticationRequestMatcher() {

        return new AntPathRequestMatcher(REST_PATH_PREFIX);
    }

    /**
     * @return user details service.
     */
    @Bean
    public UserDetailsService userDetailsService() {

        return new NurseNotesUserDetailsService();
    }

    /**
     * @return authentication entry points.
     */
    @Bean
    public LinkedHashMap<RequestMatcher, AuthenticationEntryPoint>
    entryPoints() {
        LinkedHashMap<RequestMatcher,
                AuthenticationEntryPoint> entryPoints =
                new LinkedHashMap<>();
        entryPoints.put(basicAuthenticationRequestMatcher(),
                basicAuthenticationEntryPoint());
        return entryPoints;
    }

    /**
     * @return authentication entry point.
     */
    @Bean
    public AuthenticationEntryPoint oauthEntryPoint() {
        OAuthAuthenticationEntryPoint oAuthAuthenticationEntryPoint =
                new OAuthAuthenticationEntryPoint();
        oAuthAuthenticationEntryPoint
                .setMessageConverter(new MappingJackson2HttpMessageConverter());
        return oAuthAuthenticationEntryPoint;
    }
}
