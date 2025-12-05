package com.rslakra.melody.iws.framework.persistence.entity;

import com.rslakra.appsuite.core.ToString;
import com.rslakra.melody.iws.framework.persistence.listener.BaseEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Rohtash Lakra
 * @created 8/4/21 5:59 PM
 */
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(BaseEntityListener.class)
@MappedSuperclass
public abstract class AbstractEntity<U> extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(AbstractEntity.class).toString();
    }
}
