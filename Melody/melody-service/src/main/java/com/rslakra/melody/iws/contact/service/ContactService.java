package com.rslakra.melody.iws.contact.service;

import com.rslakra.appsuite.spring.service.AbstractService;
import com.rslakra.melody.iws.contact.persistence.entity.Contact;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */
public interface ContactService extends AbstractService<Contact, Long> {

    /**
     * Returns the contact by email.
     *
     * @param email
     * @return
     */
    Contact getByEmail(String email);

}

