package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * This interface communicates with the Database of the Activities.
 */
@Repository
public interface ActivityRepository extends
        JpaRepository<ActivityEntity, Long> {

    /**
     *
     * @param date is the Client's activity-date.
     * @return It returns the Activity of chosen Client.
     */
    ActivityEntity findByDate(LocalDate date);

    /**
     * Finds every activity of a client.
     */

    List<ActivityEntity> findByClientActivity(ClientEntity client);
}
