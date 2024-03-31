package com.rslakra.melody.iws.framework.filter;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.appsuite.core.Payload;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 10:33 AM
 */
public abstract class AbstractFilter<T> implements Filter<T> {

    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "firstName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String LAST_NAME = "lastName";
    public static final String NAME = "name";

    private final Payload<String, Object> payload;

    /**
     * @param allParams
     */
    public AbstractFilter(final Map<String, Object> allParams) {
        payload = Payload.newBuilder();
        payload.putAll(allParams);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean hasKey(String key) {
        return payload.containsKey(key);
    }

    /**
     * @param keys
     * @return
     */
    @Override
    public boolean hasKeys(final String... keys) {
        return (BeanUtils.isNotEmpty(keys) && payload.keySet().containsAll(Arrays.asList(keys)));
    }

    /**
     * @param keyName
     * @return
     */
    @Override
    public Object getValue(String keyName) {
        return (hasKey(keyName) ? payload.get(keyName) : null);
    }

    /**
     * Returns the <code>E</code> object for the provided <code>keyName</code>.
     *
     * @param keyName
     * @param classType
     * @return
     */
    @Override
    public <E> E asType(String keyName, Class<E> classType) {
        E result = null;
        if (hasKey(keyName)) {
            Object object = getValue(keyName);
            if (BeanUtils.isKindOf(object, classType)) {
                result = (E) object;
            }
        } else {
            result = BeanUtils.asType(null, classType);
        }

        return result;
    }

    /**
     * Apply filter on the provided <code>T</code> object.
     *
     * @param t
     * @return
     */
    @Override
    public boolean apply(T t) {
        return false;
    }

    /**
     * @param keyName
     * @return
     */
    @Override
    public Long getLong(String keyName) {
        return asType(keyName, Long.class);
    }

    /**
     * @param keyName
     * @return
     */
    @Override
    public boolean getBoolean(String keyName) {
        return asType(keyName, Boolean.class);
    }
}
