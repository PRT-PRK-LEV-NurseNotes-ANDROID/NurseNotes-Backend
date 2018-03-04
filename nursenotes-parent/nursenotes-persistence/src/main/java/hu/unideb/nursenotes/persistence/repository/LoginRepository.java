package hu.unideb.nursenotes.persistence.repository;

import hu.unideb.nursenotes.persistence.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
}
