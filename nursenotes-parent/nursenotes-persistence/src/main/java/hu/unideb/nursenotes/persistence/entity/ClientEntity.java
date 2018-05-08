package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.*;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_CLIENT)
public class ClientEntity extends BaseEntity<Long>{

    @Column(name = COLUMN_NAME_CLIENTDATA_CLIENTFIRSTNAME)
    private String firstName;

    @Column(name = COLUMN_NAME_CLIENTDATA_CLIENTLASTNAME)
    private String lastName;

    @Column(name = COLUMN_NAME_CLIENTDATA_AGE)
    private int age;

    @Column(name = COLUMN_NAME_CLIENTDATA_SIGNATURE)
    private String signature;

    @Column(name = COLUMN_NAME_CLIENTDATA_PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = COLUMN_NAME_CLIENTDATA_ADDRESS)
    private String address;

    @Column(name = COLUMN_NAME_CLIENTDATA_WAGE)
    private int wage;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = TABLE_NAME_CLIENT)
    private List<ActivityEntity> activity;

    @Builder
    public ClientEntity(Long id, String firstName, String lastName, int age, String signature, String phoneNumber, String address, int wage) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.signature = signature;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wage = wage;
    }
}
