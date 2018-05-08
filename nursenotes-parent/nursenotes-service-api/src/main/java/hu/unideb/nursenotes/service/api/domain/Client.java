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
public class Client implements Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String signature;
    private String phoneNumber;
    private String address;
    private int wage;



}
