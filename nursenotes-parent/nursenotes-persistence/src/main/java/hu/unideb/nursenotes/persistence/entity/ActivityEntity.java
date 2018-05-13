package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_DATE;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_TIMESPENT;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_TRAVELTIME;
import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.COLUMN_NAME_ACTIVITY_TYPE;
import static hu.unideb.nursenotes.commons.pojo.table.TableName.TABLE_NAME_ACTIVITY;

/**
 * Activity Entity contains the main variables of an Activity.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE_NAME_ACTIVITY)
public class ActivityEntity extends BaseEntity<Long> {

    /**
     * Traveling time to a Client.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_TRAVELTIME)
    private LocalDateTime travelTime;

    /**
     * Spent time at a Client.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_TIMESPENT)
    private String timeSpent;

    /**
     * Type of Activity at a Client.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_TYPE)
    private String type;

    /**
     * Date of Activity.
     */
    @Column(name = COLUMN_NAME_ACTIVITY_DATE)
    private LocalDate date;

    /**
     * Clients to activities.
     */
    @ManyToMany(mappedBy = TABLE_NAME_ACTIVITY, fetch = FetchType.LAZY)
    private List<ClientEntity> client;

    /**
     * @param id         activity id.
     * @param travelTime of employee to client.
     * @param timeSpent  at client.
     * @param type       of activity.
     * @param date       of activity.
     */
    @Builder
    protected ActivityEntity(final Long id,
                             final LocalDateTime travelTime,
                             final String timeSpent, final String type,
                             final LocalDate date) {
        super(id);
        this.travelTime = travelTime;
        this.timeSpent = timeSpent;
        this.type = type;
        this.date = date;
    }
}
