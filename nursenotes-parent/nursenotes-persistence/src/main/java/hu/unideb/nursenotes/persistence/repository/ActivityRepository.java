package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface communicates with the Database of the Activities.
 */
@Repository
public interface ActivityRepository extends
        JpaRepository<ActivityEntity, Long> {

    /**
     * Activity list service, it finds the client by ID.
     *
     * @param id the ID of client.
     * @return the list of activities at client.
     */
    List<ActivityEntity> findByClientId(@Param("id") long id);

}
