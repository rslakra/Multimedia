package com.rslakra.melody.iws.account.filter;

import com.devamatre.appsuite.spring.filter.AbstractFilter;
import com.rslakra.melody.iws.account.persistence.entity.Role;

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
