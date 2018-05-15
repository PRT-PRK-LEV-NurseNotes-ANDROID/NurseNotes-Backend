package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface communicates with the Database of the Clients.
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
