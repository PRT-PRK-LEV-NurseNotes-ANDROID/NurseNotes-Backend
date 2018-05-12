package hu.unideb.nursenotes.persistence.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Base Entity which provides the primary key.
 * @param <T> is id.
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseEntity<T extends Serializable> implements Serializable {

    /**
     * Generated Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;
}
