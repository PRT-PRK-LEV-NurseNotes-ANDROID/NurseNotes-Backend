package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

//    @Query("SELECT  c FROM  ClientEntity c WHERE c.email = :email")
//    ClientEntity findByEmail(@Param("email") String email);
//
//    @Query("SELECT  c FROM  ClientEntity c WHERE c.id = :id")
//    ClientEntity findById(@Param("id") long id);
//
//    @Query("SELECT  count(c) from ClientEntity c")
//    Long countClients();
//
//    @Query("SELECT  count(c) from ClientEntity c")
//    List<String> getAllEmail();

}
