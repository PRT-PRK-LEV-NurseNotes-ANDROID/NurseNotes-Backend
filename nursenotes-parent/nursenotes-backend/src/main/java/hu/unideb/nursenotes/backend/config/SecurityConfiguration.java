package hu.unideb.nursenotes.backend.config;

import hu.unideb.nursenotes.backend.security.NurseNotesUserDetails;
import hu.unideb.nursenotes.backend.security.NurseNotesUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.LinkedHashMap;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles(new String[]{"ADMIN"});
//    }

    private static final String BASIC_AUTH_REALM_NAME = "nursenotes";

    private static final String LOGIN_FORM_PATH = "/login";

    private static final String REST_PATH_PREFIX = "/rest";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();http.httpBasic().and().exceptionHandling().authenticationEntryPoint(delegatingAuthenticationEntryPoint());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public AuthenticationEntryPoint delegatingAuthenticationEntryPoint() {
        DelegatingAuthenticationEntryPoint delegatingAuthenticationEntryPoint = new DelegatingAuthenticationEntryPoint(entryPoints());
        delegatingAuthenticationEntryPoint.setDefaultEntryPoint(loginUrlAuthenticationEntryPoint());
        return delegatingAuthenticationEntryPoint;
    }

    @Bean
    public AuthenticationEntryPoint basicAuthenticationEntryPoint() {
        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint = new BasicAuthenticationEntryPoint();
        basicAuthenticationEntryPoint.setRealmName(BASIC_AUTH_REALM_NAME);
        return basicAuthenticationEntryPoint;
    }

    @Bean
    public AuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint(LOGIN_FORM_PATH);
    }

    @Bean
    public RequestMatcher basicAuthenticationRequestMatcher() {
        return new AntPathRequestMatcher(REST_PATH_PREFIX);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new NurseNotesUserDetailsService();
    }

    @Bean
    public LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> entryPoints() {
        LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> entryPoints = new LinkedHashMap<>();
        entryPoints.put(basicAuthenticationRequestMatcher(), basicAuthenticationEntryPoint());
        return entryPoints;
    }
}