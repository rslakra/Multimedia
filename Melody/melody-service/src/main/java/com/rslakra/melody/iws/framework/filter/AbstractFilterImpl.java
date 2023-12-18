package com.rslakra.melody.iws.framework.filter;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.appsuite.core.Payload;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 10:33 AM
 */
public abstract class AbstractFilterImpl implements Filter {

    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "firstName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String LAST_NAME = "lastName";
    public static final String NAME = "name";

    private final Payload payload;

    /**
     * @param allParams
     */
    public AbstractFilterImpl(final Map<String, Object> allParams) {
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
    public String getValue(String keyName) {
        return (hasKey(keyName) ? payload.get(keyName).toString() : null);
    }

    /**
     * @param keyName
     * @return
     */
    @Override
    public Long getLong(String keyName) {
        return hasKey(keyName) ? Long.valueOf(getValue(keyName)) : null;
    }

    /**
     * @param keyName
     * @return
     */
    @Override
    public boolean getBoolean(String keyName) {
        return hasKey(keyName) ? Boolean.valueOf(getValue(keyName)) : false;
    }
}
