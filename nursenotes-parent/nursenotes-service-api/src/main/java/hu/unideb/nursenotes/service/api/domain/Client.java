package hu.unideb.nursenotes.service.api.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Client implements Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String signature;
    private String phoneNumber;
    private int wage;



}
