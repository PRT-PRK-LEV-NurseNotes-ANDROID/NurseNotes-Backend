package hu.unideb.nursenotes.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_PASSWORD;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.LoginColumName.COLUMN_NAME_USER;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_LOGIN;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TABLE_NAME_LOGIN)
public class LoginEntity extends BaseEntity<Long>{

    @Column(name = COLUMN_NAME_USER)
    private String username;

    @Column(name = COLUMN_NAME_PASSWORD)
    private String password;

    @Builder
    public LoginEntity(Long id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }
}
