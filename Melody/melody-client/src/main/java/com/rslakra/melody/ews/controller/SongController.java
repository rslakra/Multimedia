package com.rslakra.melody.ews.controller;

import com.rslakra.melody.ews.entity.Artist;
import com.rslakra.melody.ews.entity.Song;
import com.rslakra.melody.ews.service.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 5:08 PM
 */
@RestController
@RequestMapping("/songs")
public class SongController {

    private DataStore dataStore;

    /**
     * @param dataStore
     */
    public SongController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    /**
     * @return
     */
    @GetMapping("/{artistName}")
    @ResponseBody
    public List<Song> getSongs(@PathVariable String artistName) {
        Artist artist = dataStore.getArtistByName(artistName);
        if (Objects.nonNull(artist)) {
            return artist.getSongs();
        }

        return null;
    }

    /**
     * @param title
     * @param artistName
     * @return
     */
    @PostMapping("/{title}/{artistName}")
    @ResponseBody
    public Song createSong(@PathVariable String title, @PathVariable String artistName) {
        Song song = new Song(null, title, 0);
        Artist artist = dataStore.getArtistByName(artistName);
        song = dataStore.createSong(artist, song);
        return song;
    }

}
