package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_DATE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_TIMESPENT;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_TRAVELTIME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_TYPE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.ClientdataColumName.COLUMN_NAME_CLIENT_ID;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_ACTIVITY;

/**
 * Activity Entity contains the main variables of an Activity.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_ACTIVITY)
public class ActivityEntity extends BaseEntity<Long> {

    /**
     * Traveling time to a Client.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_TRAVELTIME)
    private Integer travelTime;

    /**
     * Spent time at a Client.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_TIMESPENT)
    private String timeSpent;

    /**
     * Type of Activity at a Client.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_TYPE)
    @ElementCollection(targetClass = String.class)
    private List<String> type;

    /**
     * Date of Activity.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_DATE)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = COLUMN_NAME_CLIENT_ID, nullable = false)
    private ClientEntity client;

    /**
     * @param id         activity id.
     * @param travelTime of employee to client.
     * @param timeSpent  at client.
     * @param type       of activity.
     * @param date       of activity.
     * @param clientEntity client entity.
     */
    @Builder
    public ActivityEntity(Long id, Integer travelTime, String timeSpent,
                          List<String> type, LocalDate date,
                          ClientEntity clientEntity) {
        super(id);
        this.travelTime = travelTime;
        this.timeSpent = timeSpent;
        this.type = type;
        this.date = date;
        this.client = clientEntity;
    }
}
