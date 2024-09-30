package com.rslakra.melody.iws.account.filter;

import com.rslakra.appsuite.spring.filter.AbstractFilter;
import com.rslakra.melody.iws.account.persistence.entity.User;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 1:06 PM
 */
public final class UserFilter extends AbstractFilter<User> {

    /**
     * @param allParams
     */
    public UserFilter(final Map<String, Object> allParams) {
        super(allParams);
    }
}
