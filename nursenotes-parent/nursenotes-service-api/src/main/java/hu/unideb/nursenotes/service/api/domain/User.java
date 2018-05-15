package hu.unideb.nursenotes.service.api.domain;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * User domain class.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = "password")
@ToString(exclude = "password")
@Builder
public class User implements Serializable {

    private Long id;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * First name of the user.
     */
    private String firstName;

    /**
     * Last name of the user.
     */
    private String lastName;

    /**
     * User created date.
     */
    private LocalDate createdDate;


}
