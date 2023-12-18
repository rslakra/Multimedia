package com.rslakra.melody.iws.framework.filter;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 10:32 AM
 */
public interface Filter {

    /**
     * @param key
     * @return
     */
    boolean hasKey(final String key);

    /**
     * @param keys
     * @return
     */
    boolean hasKeys(final String... keys);

    /**
     * @param keyName
     * @return
     */
    String getValue(final String keyName);

    /**
     * @param keyName
     * @return
     */
    Long getLong(final String keyName);

    /**
     * @param keyName
     * @return
     */
    boolean getBoolean(final String keyName);

}
