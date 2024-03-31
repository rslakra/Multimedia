package com.rslakra.melody.ews.controller;

import com.rslakra.melody.ews.entity.Artist;
import com.rslakra.melody.ews.service.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 5:08 PM
 */
@RestController
@RequestMapping("/artists")
public class ArtistController {

    private DataStore dataStore;
    private Artist artist;

    /**
     * @param dataStore
     */
    public ArtistController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    /**
     * @return
     */
    @GetMapping
    @ResponseBody
    public List<Artist> getArtists() {
        if (Objects.isNull(artist)) {
            return dataStore.getArtists();
        }

        return Arrays.asList(artist);
    }

    /**
     * @param byName
     * @return
     */
    @PostMapping("/{byName}")
    @ResponseBody
    public Artist createArtist(@PathVariable String byName) {
        artist = dataStore.createArtist(byName);
        return artist;
    }

}
