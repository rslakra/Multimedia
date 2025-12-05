package com.rslakra.melody.iws.contact.persistence.repository;

import com.rslakra.appsuite.spring.persistence.repository.BaseRepository;
import com.rslakra.melody.iws.contact.persistence.entity.Contact;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */
@Repository
public interface ContactRepository extends BaseRepository<Contact, Long> {

    /**
     * @param email
     * @return
     */
    Optional<Contact> findByEmail(@Param("email") String email);

}

