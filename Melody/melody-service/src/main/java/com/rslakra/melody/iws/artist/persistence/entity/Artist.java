package com.rslakra.melody.iws.artist.persistence.entity;

import com.devamatre.appsuite.core.BeanUtils;
import com.rslakra.melody.iws.account.persistence.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "artists")
public class Artist extends Person {

    @Transient
    private List<Song> songs = new ArrayList<>();

    public Artist(Long id, String name) {
        setId(id);
        setFirstName(name);
    }

    /**
     * @param song
     */
    public void addSong(Song song) {
        if (BeanUtils.isNull(song.getArtistId())) {
            song.setArtistId(getId());
        }
        songs.add(song);
    }

    /**
     * @param song
     */
    public void removeSong(Song song) {
        songs.remove(song);
        song.setArtistId(null);
    }

}
