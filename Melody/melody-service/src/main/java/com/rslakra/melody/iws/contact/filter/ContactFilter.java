package com.rslakra.melody.iws.contact.filter;

import com.rslakra.appsuite.spring.filter.AbstractFilter;
import com.rslakra.melody.iws.contact.persistence.entity.Contact;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */
public final class ContactFilter extends AbstractFilter<Contact> {

    /**
     * @param allParams
     */
    public ContactFilter(Map<String, Object> allParams) {
        super(allParams);
    }
}

