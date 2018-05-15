package hu.unideb.nursenotes.service.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static hu.unideb.nursenotes.commons.pojo.table.ColumnName.AcitivityColumName.*;

/**
 * Activity domain class.
 */
@Data
@Builder
public class Activity implements Serializable {

    /**
     * ID of an activity.
     */
    private Long id;

    /**
     * Traveling time to a Client.
     */
    private Integer travelTime;

    /**
     * Spent time at a Client.
     */
    private String timeSpent;

    /**
     * Type of Activity at a Client.
     */
    private List<String> type;

    /**
     * Date of Activity.
     */
    private LocalDate date;

    private Client client;

}
