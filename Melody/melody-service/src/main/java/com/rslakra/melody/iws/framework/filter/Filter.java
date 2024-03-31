package com.rslakra.melody.iws.framework.filter;

import java.io.Serializable;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 10:32 AM
 */
public interface Filter<T> extends Serializable {

    String ID = "id";

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
    Object getValue(final String keyName);

    /**
     * Returns the <code>E</code> object for the provided <code>keyName</code>.
     *
     * @param keyName
     * @param classType
     * @param <E>
     * @return
     */
    <E> E asType(String keyName, Class<E> classType);

    /**
     * Apply filter on the provided <code>T</code> object.
     *
     * @param t
     * @return
     */
    boolean apply(T t);

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
