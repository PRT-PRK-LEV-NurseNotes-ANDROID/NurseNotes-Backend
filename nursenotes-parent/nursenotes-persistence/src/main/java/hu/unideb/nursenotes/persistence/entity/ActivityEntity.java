package hu.unideb.nursenotes.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
     * Login to activities.
     */
    @ManyToOne
    private UserEntity login;

    /**
     * Client to activities.
     */
    @ManyToOne
    private ClientEntity client;

    /**
     *
     * @param actId activity id.
     * @param actTravelTime of employee to client.
     * @param actTimeSpent at client.
     * @param actType of activity.
     * @param actDate of activity.
     */
    @Builder
    protected ActivityEntity(final Long actId,
                             final LocalDateTime actTravelTime,
                             final String actTimeSpent, final String actType,
                             final LocalDate actDate) {
        super(actId);
        this.travelTime = actTravelTime;
        this.timeSpent = actTimeSpent;
        this.type = actType;
        this.date = actDate;
    }
}
