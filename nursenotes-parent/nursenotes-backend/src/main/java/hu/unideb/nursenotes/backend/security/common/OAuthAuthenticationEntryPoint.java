package hu.unideb.nursenotes.backend.security.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Authentication entry point class.
 */
@Slf4j
public class OAuthAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private HttpMessageConverter messageConverter;

    /**
     * Response
     *
     * @param request the request.
     * @param response the response.
     * @param exception as exception.
     * @throws IOException as exception.
     * @throws ServletException as exception.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException exception) throws IOException, ServletException {

        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized!");

    }

    public void setMessageConverter(HttpMessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

}
