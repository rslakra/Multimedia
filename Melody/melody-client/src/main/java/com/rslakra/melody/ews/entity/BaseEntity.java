package com.rslakra.melody.ews.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:57 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {

    private Long id;

    /**
     * @param id
     */
    public BaseEntity(Long id) {
        this.id = id;
    }
}
