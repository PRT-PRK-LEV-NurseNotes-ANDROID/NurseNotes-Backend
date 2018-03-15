package hu.unideb.nursenotes.service.api.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Login implements Serializable {

    private Long id;
    private String userName;
    private String password;


}
