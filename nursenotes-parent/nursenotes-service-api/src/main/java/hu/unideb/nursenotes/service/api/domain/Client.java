package hu.unideb.nursenotes.service.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Client domain class.
 */
@Data
@Builder
public class Client implements Serializable {

    /**
     * ID of the Client.
     */
    private Long id;

    /**
     * First name of the Client.
     */
    private String firstName;

    /**
     * Last name of the Client.
     */
    private String lastName;

    /**
     * Age of the Client.
     */
    private int age;

    /**
     * Signature of the Client.
     */
    private String signature;

    /**
     * Phone number of the Client.
     */
    private String phoneNumber;

    /**
     * Address of the Client.
     */
    private String address;

    /**
     * Wage of the Client.
     */
    private int wage;

    @JsonIgnore
    private User user;

}
