package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.*;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_LOGIN;


@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_LOGIN)
public class LoginEntity extends BaseEntity<Long>{

    @Column(name = COLUMN_NAME_USER)
    private String userName;

    @Column(name = COLUMN_NAME_PASSWORD)
    private String password;

    @Column(name = COLUMN_NAME_EMAIL)
    private String email;

    @Column(name = COLUMN_NAME_FIRSTNAME)
    private String firstName;

    @Column(name = COLUMN_NAME_LASTNAME)
    private String lastName;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = TABLE_NAME_LOGIN)
    private List<ActivityEntity> activity;

    @Builder
    public LoginEntity(Long id, String userName, String password, String email, String firstName, String lastName) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
