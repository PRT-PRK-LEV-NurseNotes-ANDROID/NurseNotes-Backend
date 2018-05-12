package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_ADDRESS;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_AGE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_CLIENTFIRSTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_CLIENTLASTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_PHONE_NUMBER;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_SIGNATURE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENTDATA_WAGE;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_CLIENT;

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
    @OneToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            mappedBy = TABLE_NAME_CLIENT)
    private List<ActivityEntity> activity;

    /**
     *
     * @param cliId is the id of client.
     * @param cliFirstName is the First name of client.
     * @param cliLastName is the Last name of client.
     * @param cliAge is the age of client.
     * @param cliSignature is the signature of client.
     * @param cliPhoneNumber phone number of client.
     * @param cliAddress is the address of client.
     * @param cliWage is the wage of client.
     */
    @Builder
    public ClientEntity(final Long cliId, final String cliFirstName,
                        final String cliLastName,
                        final int cliAge, final String cliSignature,
                        final String cliPhoneNumber, final String cliAddress,
                        final int cliWage) {
        super(cliId);
        this.firstName = cliFirstName;
        this.lastName = cliLastName;
        this.age = cliAge;
        this.signature = cliSignature;
        this.phoneNumber = cliPhoneNumber;
        this.address = cliAddress;
        this.wage = cliWage;
    }
}
