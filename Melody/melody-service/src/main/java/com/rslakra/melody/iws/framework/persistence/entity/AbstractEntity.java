package com.rslakra.melody.iws.framework.persistence.entity;

import com.devamatre.appsuite.core.ToString;
import com.rslakra.melody.iws.framework.persistence.listener.BaseEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
