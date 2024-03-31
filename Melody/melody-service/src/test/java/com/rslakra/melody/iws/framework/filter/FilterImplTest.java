package com.rslakra.melody.iws.framework.filter;

import com.rslakra.melody.iws.account.persistence.entity.User;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 3/12/24 11:15 AM
 */
public class FilterImplTest extends FilterImpl<User> {

    /**
     * @param allParams
     */
    public FilterImplTest(Map<String, Object> allParams) {
        super(allParams);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public boolean apply(User user) {
        return super.apply(user);
    }
}
