package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

    @Query("SELECT  a FROM  ActivityEntity a WHERE a.type = :type")
    ActivityEntity findByName(@Param("type") String type);

    @Query("SELECT  a FROM  ActivityEntity a WHERE a.id = :id")
    ActivityEntity findById(@Param("id") long id);

    List<ActivityEntity> findByClientId(@Param("id") long id);

    @Query("SELECT  count(a) from ActivityEntity a")
    Long countActivities();
}
