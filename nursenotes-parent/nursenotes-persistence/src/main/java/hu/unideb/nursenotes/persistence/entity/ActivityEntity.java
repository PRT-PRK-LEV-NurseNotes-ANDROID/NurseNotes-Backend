package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.*;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_ACTIVITY)
public class ActivityEntity extends BaseEntity<Long> {

    @Column(name = COLUMN_NAME_ACTIVITY_TRAVELTIME)
    private LocalDate travelTime;

    @Column(name = COLUMN_NAME_ACTIVITY_TIMESPENT)
    private String timeSpent;

    @Column(name = COLUMN_NAME_ACTIVITY_TYPE)
    private String type;

    @Column(name = COLUMN_NAME_ACTIVITY_DATE)
    private LocalDate date;

    @ManyToOne
    private LoginEntity login;

    @ManyToOne
    private ClientEntity client;

    @Builder
    public ActivityEntity(Long id, LocalDate travelTime, String timeSpent, String type, LocalDate date) {
        super(id);
        this.travelTime = travelTime;
        this.timeSpent = timeSpent;
        this.type = type;
        this.date = date;
    }
}
