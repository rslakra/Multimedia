package com.rslakra.melody.iws.contact.controller;

import com.rslakra.appsuite.core.Payload;
import com.rslakra.appsuite.spring.controller.rest.AbstractRestController;
import com.rslakra.appsuite.spring.exception.InvalidRequestException;
import com.rslakra.appsuite.spring.filter.Filter;
import com.rslakra.melody.iws.contact.filter.ContactFilter;
import com.rslakra.melody.iws.contact.persistence.entity.Contact;
import com.rslakra.melody.iws.contact.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */
@RestController
@RequestMapping("${restPrefix}/contacts")
public class ContactController extends AbstractRestController<Contact, Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    /**
     * @param contactService
     */
    @Autowired
    public ContactController(final ContactService contactService) {
        LOGGER.debug("ContactController({})", contactService);
        this.contactService = contactService;
    }

    /**
     * Returns the list of <code>T</code> objects.
     *
     * @return
     */
    @GetMapping
    @Override
    public List<Contact> getAll() {
        return contactService.getAll();
    }

    /**
     * Returns the list of <code>T</code> filters objects.
     *
     * @param allParams
     * @return
     */
    @GetMapping("/filter")
    @Override
    public List<Contact> getByFilter(@RequestParam Map<String, Object> allParams) {
        LOGGER.debug("+getByFilter({})", allParams);
        ContactFilter contactFilter = new ContactFilter(allParams);
        List<Contact> contacts = contactService.getByFilter(contactFilter);
        LOGGER.debug("-getByFilter(), contacts: {}", contacts);
        return contacts;
    }

    /**
     * Returns the <code>Page<T></code> list of objects filtered with <code>allParams</code>.
     *
     * @param allParams
     * @param pageable
     * @return
     */
    @GetMapping("/pageable")
    @Override
    public Page<Contact> getByFilter(Map<String, Object> allParams, Pageable pageable) {
        LOGGER.debug("+getByFilter({}, {})", allParams, pageable);
        ContactFilter contactFilter = new ContactFilter(allParams);
        Page<Contact> contacts = contactService.getByFilter(contactFilter, pageable);
        LOGGER.debug("-getByFilter(), contacts: {}", contacts);
        return contacts;
    }

    /**
     * @param filter
     * @return
     */
    @Override
    public List<Contact> getByFilter(Filter filter) {
        return null;
    }

    /**
     * @param filter
     * @param pageable
     * @return
     */
    @Override
    public Page<Contact> getByFilter(Filter filter, Pageable pageable) {
        return null;
    }

    /**
     * Creates the <code>T</code> type object.
     *
     * @param contact
     * @return
     */
    @PostMapping
    @ResponseBody
    @Override
    public ResponseEntity<Contact> create(@Validated @RequestBody Contact contact) {
        LOGGER.debug("+create({})", contact);
        contact = contactService.create(contact);
        LOGGER.debug("-create(), contact: {}", contact);
        return ResponseEntity.ok(contact);
    }

    /**
     * Creates the list of <code>T</code> type objects.
     *
     * @param contacts
     * @return
     */
    @PostMapping("/batch")
    @ResponseBody
    @Override
    public ResponseEntity<List<Contact>> create(@Validated @RequestBody List<Contact> contacts) {
        LOGGER.debug("+create({})", contacts);
        contacts = contactService.create(contacts);
        LOGGER.debug("-create(), contacts: {}", contacts);
        return ResponseEntity.ok(contacts);
    }

    /**
     * Updates the <code>T</code> type object.
     *
     * @param contact
     * @return
     */
    @PutMapping
    @Override
    public ResponseEntity<Contact> update(@Validated @RequestBody Contact contact) {
        LOGGER.debug("+update({})", contact);
        contact = contactService.update(contact);
        LOGGER.debug("-update(), contact: {}", contact);
        return ResponseEntity.ok(contact);
    }

    /**
     * Updates the list of <code>T</code> type objects.
     *
     * @param contacts
     * @return
     */
    @PutMapping("/batch")
    @Override
    public ResponseEntity<List<Contact>> update(@Validated @RequestBody List<Contact> contacts) {
        LOGGER.debug("+update({})", contacts);
        contacts = contactService.update(contacts);
        LOGGER.debug("-update(), contacts: {}", contacts);
        return ResponseEntity.ok(contacts);
    }

    /**
     * Deletes the <code>T</code> type object by <code>id</code>.
     *
     * @param idOptional
     * @return
     */
    @DeleteMapping("/{contactId}")
    @Override
    public ResponseEntity<Payload> delete(@PathVariable(value = "contactId") Optional<Long> idOptional) {
        validate(idOptional);
        if (idOptional.isPresent()) {
            Long contactId = idOptional.get();
            contactService.delete(contactId);
            Payload payload = Payload.newBuilder()
                .withDeleted(Boolean.TRUE)
                .withMessage("Record with id:%d deleted successfully!", contactId);
            return ResponseEntity.ok(payload);
        } else {
            throw new InvalidRequestException();
        }
    }

    /**
     * Uploads the <code>file</code>
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @Override
    public ResponseEntity<Payload> upload(MultipartFile file) {
        return null;
    }

    /**
     * Downloads the object of <code>T</code> as <code>fileType</code> file.
     *
     * @param fileType
     * @return
     */
    @GetMapping("/download")
    @Override
    public ResponseEntity<Resource> download(String fileType) {
        return null;
    }

}

