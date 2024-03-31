package com.rslakra.melody.ews.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class Artist extends NamedEntity {

    private List<Song> songs = new ArrayList<>();

    /**
     * @param id
     * @param name
     */
    public Artist(Long id, String name) {
        super(id, name);
    }

}
