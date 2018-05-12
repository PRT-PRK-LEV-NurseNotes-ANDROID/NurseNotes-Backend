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

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_EMAIL;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_FIRSTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_LASTNAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_PASSWORD;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_USER;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_LOGIN;

/**
 * Login Entity class contains the values of a Login.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_LOGIN)
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
    @OneToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            mappedBy = TABLE_NAME_LOGIN)
    private List<ActivityEntity> activity;

    /**
     *
     * @param logId Login ID.
     * @param logUserName Username.
     * @param logPassword Password.
     * @param logEmail email.
     * @param logFirstName user first name.
     * @param logLastName user last name.
     */
    @Builder
    public UserEntity(final Long logId, final String logUserName,
                      final String logPassword, final String logEmail,
                      final String logFirstName, final String logLastName) {
        super(logId);
        this.userName = logUserName;
        this.password = logPassword;
        this.email = logEmail;
        this.firstName = logFirstName;
        this.lastName = logLastName;
    }
}
