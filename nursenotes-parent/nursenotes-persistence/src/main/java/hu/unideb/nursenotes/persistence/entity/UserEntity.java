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

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_EMAIL;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_FIRSTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_LASTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_PASSWORD;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_USER;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_USER;
import static javax.persistence.CascadeType.ALL;

/**
 * Login Entity class contains the values of a User.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_USER)
public class UserEntity extends BaseEntity<Long> {

    /**
     * User name of the employee.
     */
    @Column(name = COLUMN_NAME_USER)
    private String userName;

    /**
     * Password of the employee.
     */
    @Column(name = COLUMN_NAME_PASSWORD)
    private String password;

    /**
     * E-mail address of the employee.
     */
    @Column(name = COLUMN_NAME_EMAIL)
    private String email;

    /**
     * First name of the employee.
     */
    @Column(name = COLUMN_NAME_FIRSTNAME)
    private String firstName;

    /**
     * Last name of the employee.
     */
    @Column(name = COLUMN_NAME_LASTNAME)
    private String lastName;

    /**
     * Activity list to login.
     */
    @OneToMany(cascade = ALL,
            mappedBy = "userEntity")
    private List<ClientEntity> client;

    /**
     *
     * @param id Login ID.
     * @param userName Username.
     * @param password Password.
     * @param email email.
     * @param firstName user first name.
     * @param lastName user last name.
     */
    @Builder
    public UserEntity(final Long id, final String userName,
                      final String password, final String email,
                      final String firstName, final String lastName, List<ClientEntity> client) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.client = client;
    }
}
