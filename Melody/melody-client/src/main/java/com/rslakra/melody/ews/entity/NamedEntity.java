package com.rslakra.melody.ews.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rohtash Lakra (rlakra)
 * @created 5/25/22 4:58 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class NamedEntity extends BaseEntity {

    private String name;

    /**
     * @param id
     * @param name
     */
    public NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

}
