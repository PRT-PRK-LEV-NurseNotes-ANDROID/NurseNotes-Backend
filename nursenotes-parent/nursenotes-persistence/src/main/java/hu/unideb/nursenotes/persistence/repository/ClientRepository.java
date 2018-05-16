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

    /**
     * This query finds the Client by ID.
     *
     * @param id the ID of the Client.
     * @return client by the given ID.
     */
    @Query("SELECT g FROM ClientEntity g WHERE g.id = :id")
    ClientEntity findById(@Param("id") long id);

    /**
     * List of clients of the logged in user.
     *
     * @param id the ID of the user.
     * @return list of clients.
     */
    List<ClientEntity> findByUserEntityId(@Param("id") long id);

}
