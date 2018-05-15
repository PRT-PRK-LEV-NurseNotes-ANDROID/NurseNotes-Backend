package hu.unideb.nursenotes.persistence.repository;

import ch.qos.logback.core.net.server.Client;
import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import hu.unideb.nursenotes.persistence.entity.UserEntity;
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
//    /**
//     *
//     * @param phoneNumber is the Client's phone number.
//     * @return It returns the Client by phone number.
//     */
//    @Query("SELECT p FROM  ClientEntity p WHERE p.phoneNumber = :phoneNumber")
//    ClientEntity findByPhone(@Param("phoneNumber") String phoneNumber);
//
//    /**
//     * @param firstName is the Client's first Name.
//     * @return It returns the Client by first name.
//     */
//    @Query("select f from ClientEntity f where f.firstName = :firstName")
//    ClientEntity findByFName(@Param("firstName") String firstName);
//
//    /**
//     * @param lastName is the Client's last Name.
//     * @return It returns the Client by last name.
//     */
//    @Query("select l from ClientEntity l where l.lastName = :lastName")
//    ClientEntity findByLName(@Param("lastName") String lastName);
//
//    /**
//     * @param user is the logged in user.
//     * @return a list of clients of a login.
//     */
//  //  List<ClientEntity> findByUser(UserEntity user);
}
