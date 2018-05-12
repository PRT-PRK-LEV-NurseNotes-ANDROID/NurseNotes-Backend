package hu.unideb.nursenotes.service.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Activity domain class.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat
public class Activity implements Serializable {

    /**
     * ID of an activity.
     */
    private Long id;

    /**
     * Traveling time to a Client.
     */
    private LocalDateTime travelTime;

    /**
     * Time spent during the activities at a Client.
     */
    private String timeSpent;

    /**
     * The type of the activities.
     */
    private String type;

    /**
     * The date of the activities.
     */
    private LocalDate date;

}
