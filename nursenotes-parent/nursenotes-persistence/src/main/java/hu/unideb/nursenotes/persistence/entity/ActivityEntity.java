package hu.unideb.nursenotes.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.*;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_ACTIVITIES;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_ACTIVITIES)
public class ActivityEntity extends BaseEntity<Long> {

    @Column(name = COLUMN_NAME_ACTIVITY_TRAVELTIME)
    private LocalDate travelTime;

    @Column(name = COLUMN_NAME_ACTIVITY_TIMESPENT)
    private String timeSpent;

    @Column(name = COLUMN_NAME_ACTIVITY_TYPE)
    private String type;

    @Column(name = COLUMN_NAME_ACTIVITY_CLIENTNAME)
    private String name;

    @Column(name = COLUMN_NAME_ACTIVITY_WAGE)
    private int wage;

    @Column(name = COLUMN_NAME_ACTIVITY_COST)
    private int cost;

    @Builder
    public ActivityEntity(Long id, LocalDate travelTime, String timeSpent, String type, String name, int wage, int cost) {
        super(id);
        this.travelTime = travelTime;
        this.timeSpent = timeSpent;
        this.type = type;
        this.name = name;
        this.wage = wage;
        this.cost = cost;
    }
}
