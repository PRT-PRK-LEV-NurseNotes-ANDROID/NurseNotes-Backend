package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface communicates with the Database of the Activities.
 */
@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

    /**
     *
     * @param type is the name of finding by.
     * @return It returns the Activity by a chosen Client.
     */
    @Query("SELECT  a FROM  ActivityEntity a WHERE a.type = :type")
    ActivityEntity findByName(@Param("type") String type);

    /**
     *
     * @param id is the identification for finding an Acitivity.
     * @return It returns an Activity by its ID.
     */
    @Query("SELECT  a FROM  ActivityEntity a WHERE a.id = :id")
    ActivityEntity findById(@Param("id") long id);

    /**
     *
     * @param id is the Client's id.
     * @return It returns a list of the Activity of chosen Client.
     */
    List<ActivityEntity> findByClientId(@Param("id") long id);

    /**
     * It counts the Activities.
     * @return a list of all Activities.
     */
    @Query("SELECT  count(a) from ActivityEntity a")
    Long countActivities();
}
