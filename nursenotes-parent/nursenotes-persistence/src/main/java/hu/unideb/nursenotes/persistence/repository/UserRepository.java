package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface communicates with the Database of the Login.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     *
     * @param userName is the employee's name.
     * @return It returns the employee by userName.
     */
    @Query("select u from UserEntity u where u.userName = :userName")
    UserEntity findByUserName(@Param("userName") String userName);

    /**
     * @param Id is the login Id.
     * @return it returns the employee by login.
     */
    @Query("select i from UserEntity i where i.id =: Id")
    UserEntity findAllBy(@Param("Id") String Id);

    /**
     *
     * @param id of login.
     * @return every user by the given Id.
     */
    List<UserEntity> findByLoginId(@Param("id") long id);

}
