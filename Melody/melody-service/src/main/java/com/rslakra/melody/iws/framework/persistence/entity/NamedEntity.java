package com.rslakra.melody.iws.framework.persistence.entity;

import com.devamatre.appsuite.core.ToString;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Rohtash Lakra
 * @created 8/20/21 7:14 PM
 */
@Getter
@Setter
@MappedSuperclass
public class NamedEntity extends AbstractEntity<String> {

    @Column(name = "name")
    private String name;

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(NamedEntity.class)
            .add("name=" + getName())
            .toString();
    }
}
