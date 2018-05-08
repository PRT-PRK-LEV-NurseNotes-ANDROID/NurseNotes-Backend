package hu.unideb.nursenotes.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Login implements Serializable {

    /**
     * ID of the login/registration.
     */
    private Long id;

    /**
     * Username of the login/employee.
     */
    private String userName;

    /**
     * Password for the employee.
     */
    private String password;

    /**
     * First name of the employee.
     */
    private String firstName;

    /**
     * Last name of the employee.
     */
    private String lastName;

    /**
     * E-mail address of the employee.
     */
    private String email;


}
