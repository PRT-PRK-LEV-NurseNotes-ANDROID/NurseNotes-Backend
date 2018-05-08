package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    /**
     *
     * @param userName is the employee's name.
     * @return It returns the employee by userName.
     */
    @Query("select u from LoginEntity u where u.userName = :userName")
    LoginEntity findByUserName(@Param("userName") String userName);

}
