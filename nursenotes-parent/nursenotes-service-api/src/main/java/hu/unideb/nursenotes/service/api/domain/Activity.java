package hu.unideb.nursenotes.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Activity implements Serializable{

    private Long id;
    private LocalDateTime travelTime;
    private String timeSpent;
    private String type;
    private LocalDate date;

}
