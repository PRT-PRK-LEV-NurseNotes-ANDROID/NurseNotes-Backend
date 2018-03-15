package hu.unideb.nursenotes.service.api.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Activity domain class.
 */

@Data
@Builder
public class Activity implements Serializable{

    private Long id;
    private LocalDate travelTime;
    private String timeSpent;
    private String type;
    private LocalDate date;

}
