package hu.unideb.nursenotes.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.*;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_USER_ID;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_CLIENT;

/**
 * Client Entity provides the base values of a Client.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_CLIENT)
public class ClientEntity extends BaseEntity<Long> {

    /**
     * First name of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENT_FIRSTNAME)
    private String firstName;

    /**
     * Last name of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENT_LASTNAME)
    private String lastName;

    /**
     * Age of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENT_AGE)
    private int age;

    /**
     * Signature of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENT_SIGNATURE)
    private String signature;

    /**
     * Phone number of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENT_PHONENUMBER)
    private String phoneNumber;

    /**
     * Address of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENT_ADDRESS)
    private String address;

    /**
     * Wage of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENT_WAGE)
    private int wage;

    @ManyToOne
    @JoinColumn(name = COLUMN_NAME_USER_ID, nullable = false)
    private UserEntity userEntity;

    @ManyToMany(mappedBy = "clientEntities", fetch = FetchType.LAZY)
    private List<ActivityEntity> activityEntities;

    /**
     * @param id          is the id of client.
     * @param firstName   is the First name of client.
     * @param lastName    is the Last name of client.
     * @param age         is the age of client.
     * @param signature   is the signature of client.
     * @param phoneNumber phone number of client.
     * @param address     is the address of client.
     * @param wage        is the wage of client.
     */
    @Builder
    public ClientEntity(Long id, String firstName, String lastName, int age, String signature, String phoneNumber, String address, int wage, UserEntity userEntity) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.signature = signature;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wage = wage;
        this.userEntity = userEntity;
    }
}
