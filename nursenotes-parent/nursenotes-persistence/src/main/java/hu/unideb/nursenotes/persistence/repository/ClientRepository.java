package hu.unideb.nursenotes.persistence.repository;

import ch.qos.logback.core.net.server.Client;
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
     *
     * @param id is the Client id.
     * @return It returns the Client by ID.
     */
    @Query("SELECT  c FROM  ClientEntity c WHERE c.id = :id")
    ClientEntity findById(@Param("id") long id);


    /**
     * @param firstName is the Client's first Name.
     * @return It returns the Client by first name.
     */
    @Query("select f from ClientEntity f where f.firstName =: firstName")
    ClientEntity findByName(@Param("firstName") String firstName);

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

    /**
     * @param id is login Id.
     * @return a list of clients of a login.
     */
    List<ClientEntity> findByLoginId(@Param("id") long id);

    @Query("select c from ClientEntity c where c.clientName = :clientName")
    ClientEntity findClientOfEmployee(@Param("clientName") String clientName);

}
