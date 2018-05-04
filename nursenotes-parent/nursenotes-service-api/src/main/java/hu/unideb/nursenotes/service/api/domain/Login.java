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

    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;


}
