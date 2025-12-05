package com.rslakra.melody.iws.contact.service.impl;

import com.rslakra.appsuite.core.BeanUtils;
import com.rslakra.appsuite.spring.exception.DuplicateRecordException;
import com.rslakra.appsuite.spring.exception.InvalidRequestException;
import com.rslakra.appsuite.spring.exception.NoRecordFoundException;
import com.rslakra.appsuite.spring.filter.Filter;
import com.rslakra.appsuite.spring.persistence.ServiceOperation;
import com.rslakra.appsuite.spring.service.AbstractServiceImpl;
import com.rslakra.melody.iws.contact.persistence.entity.Contact;
import com.rslakra.melody.iws.contact.persistence.repository.ContactRepository;
import com.rslakra.melody.iws.contact.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */
@Service
public class ContactServiceImpl extends AbstractServiceImpl<Contact, Long> implements ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    private final ContactRepository contactRepository;

    /**
     * @param contactRepository
     */
    @Autowired
    public ContactServiceImpl(final ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     * Validates the <code>T</code> object.
     *
     * @param operation
     * @param contact
     * @return
     */
    @Override
    public Contact validate(ServiceOperation operation, Contact contact) {
        switch (operation) {
            case CREATE:
                if (BeanUtils.isEmpty(contact.getEmail())) {
                    throw new InvalidRequestException("The contact's email should provide!");
                } else if (BeanUtils.isEmpty(contact.getFirstName())) {
                    throw new InvalidRequestException("The contact's firstName should provide!");
                } else if (BeanUtils.isEmpty(contact.getLastName())) {
                    throw new InvalidRequestException("The contact's lastName should provide!");
                }

                break;

            case UPDATE:
                if (BeanUtils.isNull(contact.getId())) {
                    throw new InvalidRequestException("The contact's ID should provide!");
                }

                break;

            default:
                throw new InvalidRequestException("Unsupported ServiceOperation!");
        }

        return contact;
    }

    /**
     * @param contact
     * @return
     */
    @Override
    public Contact create(Contact contact) {
        LOGGER.debug("+create({})", contact);
        validate(ServiceOperation.CREATE, contact);

        // check for duplicate email
        Optional<Contact> existingContact = contactRepository.findByEmail(contact.getEmail());
        if (existingContact.isPresent()) {
            throw new DuplicateRecordException("Contact with email '%s' already exists!", contact.getEmail());
        }

        contact = contactRepository.save(contact);
        LOGGER.debug("-create(), contact: {}", contact);
        return contact;
    }

    /**
     * @param contacts
     * @return
     */
    @Override
    public List<Contact> create(List<Contact> contacts) {
        LOGGER.debug("+create({})", contacts);
        contacts.forEach(contact -> validate(ServiceOperation.CREATE, contact));
        contacts = contactRepository.saveAll(contacts);
        LOGGER.debug("-create(), contacts: {}", contacts);
        return contacts;
    }

    /**
     * @return
     */
    @Override
    public List<Contact> getAll() {
        LOGGER.debug("+getAll()");
        List<Contact> contacts = contactRepository.findAll();
        LOGGER.debug("-getAll(), contacts: {}", contacts);
        return contacts;
    }

    /**
     * @param filter
     * @return
     */
    @Override
    public List<Contact> getByFilter(Filter filter) {
        LOGGER.debug("+getByFilter({})", filter);
        List<Contact> contacts = getAll();
        LOGGER.debug("-getByFilter(), contacts: {}", contacts);
        return contacts;
    }

    /**
     * @param filter
     * @param pageable
     * @return
     */
    @Override
    public Page<Contact> getByFilter(Filter filter, Pageable pageable) {
        LOGGER.debug("+getByFilter({}, {})", filter, pageable);
        Page<Contact> contacts = contactRepository.findAll(pageable);
        LOGGER.debug("-getByFilter(), contacts: {}", contacts);
        return contacts;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Contact getById(Long id) {
        LOGGER.debug("+getById({})", id);
        Contact contact = contactRepository.findById(id)
            .orElseThrow(() -> new NoRecordFoundException("Contact with id '%d' not found!", id));
        LOGGER.debug("-getById(), contact: {}", contact);
        return contact;
    }

    /**
     * Returns the contact by email.
     *
     * @param email
     * @return
     */
    @Override
    public Contact getByEmail(String email) {
        LOGGER.debug("+getByEmail({})", email);
        Contact contact = contactRepository.findByEmail(email)
            .orElseThrow(() -> new NoRecordFoundException("Contact with email '%s' not found!", email));
        LOGGER.debug("-getByEmail(), contact: {}", contact);
        return contact;
    }

    /**
     * @param contact
     * @return
     */
    @Override
    public Contact update(Contact contact) {
        LOGGER.debug("+update({})", contact);
        validate(ServiceOperation.UPDATE, contact);
        Contact existingContact = getById(contact.getId());
        BeanUtils.copyProperties(contact, existingContact);
        contact = contactRepository.save(existingContact);
        LOGGER.debug("-update(), contact: {}", contact);
        return contact;
    }

    /**
     * @param contacts
     * @return
     */
    @Override
    public List<Contact> update(List<Contact> contacts) {
        LOGGER.debug("+update({})", contacts);
        contacts.forEach(contact -> validate(ServiceOperation.UPDATE, contact));
        contacts = contactRepository.saveAll(contacts);
        LOGGER.debug("-update(), contacts: {}", contacts);
        return contacts;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Contact delete(Long id) {
        LOGGER.debug("+delete({})", id);
        Contact contact = getById(id);
        contactRepository.delete(contact);
        LOGGER.debug("-delete(), contact: {}", contact);
        return contact;
    }
}

