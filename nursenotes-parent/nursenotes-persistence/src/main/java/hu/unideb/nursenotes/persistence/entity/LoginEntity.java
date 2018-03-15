package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_PASSWORD;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_USER;
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

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = TABLE_NAME_LOGIN)
    private List<ActivityEntity> activity;

    @Builder
    public LoginEntity(Long id, String userName, String password) {
        super(id);
        this.userName = userName;
        this.password = password;
    }
}
