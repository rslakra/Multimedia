package com.rslakra.melody.iws.framework.filter;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 10:33 AM
 */
public class FilterImpl<T> extends AbstractFilter<T> {

    /**
     * @param allParams
     */
    public FilterImpl(final Map<String, Object> allParams) {
        super(allParams);
    }
}
