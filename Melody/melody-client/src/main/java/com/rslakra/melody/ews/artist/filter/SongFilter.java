package com.rslakra.melody.ews.artist.filter;

import com.rslakra.appsuite.spring.filter.AbstractFilter;
import com.rslakra.melody.ews.entity.Song;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 1:06 PM
 */
public final class SongFilter extends AbstractFilter<Song> {

    public static final String ARTIST_ID = "artistId";
    public static final String TITLE = "title";


    /**
     * @param allParams
     */
    public SongFilter(Map<String, Object> allParams) {
        super(allParams);
    }
}
