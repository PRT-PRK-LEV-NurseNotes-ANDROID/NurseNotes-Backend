package hu.unideb.nursenotes.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.*;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_CLIENTS;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TABLE_NAME_CLIENTS)
public class ClientEntity extends BaseEntity<Long>{

    @Column(name = COLUMN_NAME_CLIENTDATA_NAME)
    private String name;

    @Column(name = COLUMN_NAME_CLIENTDATA_AGE)
    private int age;

    @Column(name = COLUMN_NAME_CLIENTDATA_SIGNATURE)
    private String signature;

    @Column(name = COLUMN_NAME_CLIENTDATA_PHONE_NUMBER)
    private String phoneNumber;

    @Builder
    public ClientEntity(Long id, String name, int age, String signature, String phoneNumber) {
        super(id);
        this.name = name;
        this.age = age;
        this.signature = signature;
        this.phoneNumber = phoneNumber;
    }
}
