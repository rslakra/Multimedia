package com.rslakra.melody.ews.account.filter;

import com.rslakra.appsuite.spring.filter.AbstractFilter;
import com.rslakra.melody.ews.account.payload.dto.Role;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 2/8/23 1:06 PM
 */
public final class RoleFilter extends AbstractFilter<Role> {

    /**
     * @param allParams
     */
    public RoleFilter(Map<String, Object> allParams) {
        super(allParams);
    }
}
