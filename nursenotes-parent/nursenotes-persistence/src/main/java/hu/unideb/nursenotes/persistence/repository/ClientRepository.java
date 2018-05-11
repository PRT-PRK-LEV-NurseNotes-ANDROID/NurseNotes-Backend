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

//    @Query("SELECT  c FROM  ClientEntity c WHERE c.email = :email")
//    ClientEntity findByEmail(@Param("email") String email);
//

    /**
     *
     * @param id is the Client id.
     * @return It returns the Client by ID.
     */
    @Query("SELECT  c FROM  ClientEntity c WHERE c.id = :id")
    ClientEntity findById(@Param("id") long id);

    /**
     *
     * @return It counts all Client.
     */
    @Query("SELECT  count(c) from ClientEntity c")
    Long countClients();

    /**
     *
     * @return a list of every Client.
     */
    @Query("SELECT  count(c) from ClientEntity c")
    List<ClientEntity> findAllClient();

//
//    @Query("SELECT  count(c) from ClientEntity c")
//    List<String> getAllEmail();

}
