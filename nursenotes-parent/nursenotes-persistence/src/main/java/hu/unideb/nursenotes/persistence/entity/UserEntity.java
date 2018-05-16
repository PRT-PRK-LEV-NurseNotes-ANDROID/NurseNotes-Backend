package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.exclusion.FieldExclusion.EXCLUDE_PASSWORD;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_CREATED_DATE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_EMAIL;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_FIRST_NAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_LAST_NAME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_PASSWORD;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.UserColumName.COLUMN_NAME_USERNAME;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_USER;
import static javax.persistence.CascadeType.ALL;

/**
 * UserEntity which represents the user.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = EXCLUDE_PASSWORD)
@Entity
@Table(name = TABLE_NAME_USER, uniqueConstraints =
@UniqueConstraint(columnNames = COLUMN_NAME_USERNAME))
public class UserEntity extends BaseEntity<Long> {

    /**
     * The username of the user.
     */
    @Column(name = COLUMN_NAME_USERNAME)
    private String username;

    /**
     * The email of the user.
     */
    @Column(name = COLUMN_NAME_EMAIL)
    private String email;

    /**
     * The password of the user.
     */
    @Column(name = COLUMN_NAME_PASSWORD)
    private String password;

    /**
     * First name of the user.
     */
    @Column(name = COLUMN_NAME_FIRST_NAME)
    private String firstName;

    /**
     * Last name of the user.
     */
    @Column(name = COLUMN_NAME_LAST_NAME)
    private String lastName;

    /**
     * User created date.
     */
    @Column(name = COLUMN_NAME_CREATED_DATE)
    private LocalDate createdDate;

    @OneToMany(cascade = ALL, mappedBy = "userEntity")
    private List<ClientEntity> clientEntities;

    /**
     * Builder pattern for creating user.
     * @param id user ID.
     * @param username of employee.
     * @param email of employee.
     * @param password of employee.
     * @param firstName of employee.
     * @param lastName of employee.
     * @param createdDate of registraton.
     */
    @Builder
    public UserEntity(Long id, String username, String email,
                      String password, String firstName,
                      String lastName, LocalDate createdDate) {
        super(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
    }
}
