package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_ID;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_ADDRESS;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_AGE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_CLIENTFIRSTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_CLIENTID;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_CLIENTLASTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_PHONE_NUMBER;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_SIGNATURE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_WAGE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ReferencedColumName.REFERENCED_COLUM_NAME_ID;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_CLIENT;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_CLIENT_HAS_ACTIVITY;

/**
 * Client Entity provides the base values of a Client.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_CLIENT)
public class ClientEntity extends BaseEntity<Long> {

    /**
     * First name of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENTDATA_CLIENTFIRSTNAME)
    private String firstName;

    /**
     * Last name of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENTDATA_CLIENTLASTNAME)
    private String lastName;

    /**
     * Age of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENTDATA_AGE)
    private int age;

    /**
     * Signature of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENTDATA_SIGNATURE)
    private String signature;

    /**
     * Phone number of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENTDATA_PHONE_NUMBER)
    private String phoneNumber;

    /**
     * Address of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENTDATA_ADDRESS)
    private String address;

    /**
     * Wage of the Client.
     */
    @Column(name = COLUMN_NAME_CLIENTDATA_WAGE)
    private int wage;

    /**
     * Activities to a client.
     */
    @ManyToOne
    @JoinColumn(name = "test", nullable = false)
    private UserEntity userEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_NAME_CLIENT_HAS_ACTIVITY,
            joinColumns = @JoinColumn(name = COLUMN_NAME_CLIENTDATA_CLIENTID, referencedColumnName = REFERENCED_COLUM_NAME_ID),
            inverseJoinColumns = @JoinColumn(name = COLUMN_NAME_ACTIVITY_ID, referencedColumnName = REFERENCED_COLUM_NAME_ID))
    private List<ActivityEntity> activity;

    /**
     *
     * @param id is the id of client.
     * @param firstName is the First name of client.
     * @param lastName is the Last name of client.
     * @param age is the age of client.
     * @param signature is the signature of client.
     * @param phoneNumber phone number of client.
     * @param address is the address of client.
     * @param wage is the wage of client.
     */
    @Builder
    public ClientEntity(final Long id, final String firstName,
                        final String lastName,
                        final int age, final String signature,
                        final String phoneNumber, final String address,
                        final int wage, UserEntity userEntity) {
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
