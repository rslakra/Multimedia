package com.rslakra.melody.ews.account.filter;

import com.rslakra.appsuite.spring.filter.AbstractFilter;
import com.rslakra.melody.ews.account.payload.dto.User;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 1:06 PM
 */
public final class UserFilter extends AbstractFilter<User> {

    /**
     * @param allParams
     */
    public UserFilter(Map<String, Object> allParams) {
        super(allParams);
    }
}
