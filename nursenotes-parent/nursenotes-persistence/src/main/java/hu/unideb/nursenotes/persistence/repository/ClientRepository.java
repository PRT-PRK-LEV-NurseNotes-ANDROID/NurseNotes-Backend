package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface communicates with the Database of the Clients.
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT g FROM ClientEntity g WHERE g.id = :id")
    ClientEntity findById(@Param("id") long id);

    List<ClientEntity> findByuserEntityId(@Param("id") long id);

}
