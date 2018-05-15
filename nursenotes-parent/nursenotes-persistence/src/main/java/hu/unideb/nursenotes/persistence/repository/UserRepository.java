package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This interface communicates with the Database of the Login.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u where u.username =:username")
    UserEntity findByUsername(@Param("username") String username);

}
