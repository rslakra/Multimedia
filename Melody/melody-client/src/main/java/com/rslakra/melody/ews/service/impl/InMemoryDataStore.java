package com.rslakra.melody.ews.service.impl;

import com.rslakra.melody.ews.entity.Artist;
import com.rslakra.melody.ews.entity.Song;
import com.rslakra.melody.ews.service.DataStore;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 5:01 PM
 */
@Service
public final class InMemoryDataStore implements DataStore {

    private final Map<Long, Artist> artists = new HashMap<>();
    private final Map<Long, Song> songs = new HashMap<>();

    public InMemoryDataStore() {
        // Populate the Datastore with some initial artists and songs.
        Artist gordonLightfoot = new Artist(1L, "Gordon Lightfoot");
        gordonLightfoot.getSongs().add(new Song(1L, "If You Could Read My Mind", 4));
        gordonLightfoot.getSongs().add(new Song(2L, "Sundown", 3));
        Artist beatles = new Artist(2L, "The Beatles");
        beatles.getSongs().add(new Song(3L, "If", 3));
        beatles.getSongs().add(new Song(4L, "Yellow Submarine", 2));
        Artist pinkFloyd = new Artist(3L, "Pink Floyd");
        pinkFloyd.getSongs().add(new Song(5L, "Comfortably Numb", 3));
        pinkFloyd.getSongs().add(new Song(6L, "High Hopes", 5));

        artists.put(gordonLightfoot.getId(), gordonLightfoot);
        artists.put(beatles.getId(), beatles);
        artists.put(pinkFloyd.getId(), pinkFloyd);

        for (Artist artist : artists.values()) {
            for (Song song : artist.getSongs()) {
                songs.put(song.getId(), song);
            }
        }
    }

    /**
     * @return
     */
    @Override
    public List<Artist> getArtists() {
        return artists.values().stream().collect(Collectors.toList());
    }

    /**
     * Returns an artist by name.
     *
     * @param artistName
     * @return Artist or null if not found
     */
    @Override
    public Artist getArtistByName(String artistName) {
        for (Artist artist : artists.values()) {
            if (dasherize(artistName).equalsIgnoreCase(artist.getName())) {
                return artist;
            }
        }

        return null;
    }

    /**
     * Returns an artist by ID.
     *
     * @param id
     * @return Artist or null if not found
     */
    @Override
    public Artist getArtistById(Long id) {
        return artists.get(id);
    }

    /**
     * Dasherizes a string name.
     *
     * @param str - String to dasherize
     * @return Dasherized string
     */
    private static String dasherize(String str) {
        return str == null ? null : str.replaceAll("([a-z])([A-Z])", "$1-$2").replaceAll("_", "-").toLowerCase();
    }

    /**
     * Creates a new song, puts it in the datastore, and associates it with the passed artist.
     *
     * @param artist
     * @param song
     * @return Newly created song with a populated ID
     */
    @Override
    public Song createSong(Artist artist, Song song) {
        song.setId(getNextSongId());
        songs.put(song.getId(), song);
        artist.getSongs().add(song);
        return song;
    }

    /**
     * Creates a new artist in the Datastore.
     *
     * @param name
     * @return Newly created artist object with a populated ID.
     */
    @Override
    public Artist createArtist(String name) {
        Artist artist = new Artist(getNextArtistId(), name);
        artists.put(artist.getId(), artist);
        return artist;
    }

    /**
     * Returns the next highest Artist ID in the datastore.
     *
     * @return next highest Artist ID in the datastore.
     */
    @Override
    public Long getNextArtistId() {
        long highestArtistId = 0L;

        for (Artist artist : artists.values()) {
            if (artist.getId() > highestArtistId) {
                highestArtistId = artist.getId();
            }
        }

        return highestArtistId + 1L;
    }

    /**
     * Returns the next highest Song ID in the datastore.
     *
     * @return next highest Song ID in the datastore.
     */
    @Override
    public Long getNextSongId() {
        long highestSongId = 0L;

        for (Song song : songs.values()) {
            if (song.getId() > highestSongId) {
                highestSongId = song.getId();
            }
        }

        return highestSongId + 1L;
    }
}
