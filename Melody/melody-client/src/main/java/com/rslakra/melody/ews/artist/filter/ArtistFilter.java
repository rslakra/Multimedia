package com.rslakra.melody.ews.artist.filter;

import com.devamatre.appsuite.spring.filter.AbstractFilter;
import com.rslakra.melody.ews.entity.Artist;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 1:06 PM
 */
public final class ArtistFilter extends AbstractFilter<Artist> {

    /**
     * @param allParams
     */
    public ArtistFilter(Map<String, Object> allParams) {
        super(allParams);
    }


}
