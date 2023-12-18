package com.rslakra.melody.ews.service;

import com.rslakra.melody.ews.entity.Artist;
import com.rslakra.melody.ews.entity.Song;

import java.util.List;

/**
 * @author Rohtash Lakra (rlakra)
 * @created 5/25/22 5:00 PM
 */
public interface DataStore {

    /**
     * Returns an artist by name.
     *
     * @param artistName
     * @return Artist or null if not found
     */
    public Artist getArtistByName(String artistName);

    /**
     * Returns an artist by ID.
     *
     * @param id
     * @return Artist or null if not found
     */
    public Artist getArtistById(Long id);

    /**
     * @return
     */
    public List<Artist> getArtists();

    /**
     * Creates a new song, puts it in the datastore, and associates it with the passed artist.
     *
     * @param artist
     * @param song
     * @return Newly created song with a populated ID
     */
    public Song createSong(Artist artist, Song song);

    /**
     * Creates a new artist in the Datastore.
     *
     * @param name
     * @return Newly created artist object with a populated ID.
     */
    public Artist createArtist(String name);

    /**
     * Returns the next highest Artist ID in the datastore.
     *
     * @return next highest Artist ID in the datastore.
     */
    public Long getNextArtistId();

    /**
     * Returns the next highest Song ID in the datastore.
     *
     * @return next highest Song ID in the datastore.
     */
    public Long getNextSongId();
}
