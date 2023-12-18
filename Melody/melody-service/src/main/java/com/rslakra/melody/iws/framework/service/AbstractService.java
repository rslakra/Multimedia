package com.rslakra.melody.iws.framework.service;

import com.rslakra.melody.iws.framework.filter.Filter;
import com.rslakra.melody.iws.framework.persistence.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/9/21 7:54 PM
 */
public interface AbstractService<T> {

    String[] IGNORED_PROPERTIES = {"id", "createdOn", "createdAt", "createdBy", "updatedOn", "updatedAt", "updatedBy"};

    /**
     * Validates the <code>T</code> object.
     *
     * @param t
     * @return
     */
    public T validate(Operation operation, T t);

    /**
     * Creates the <code>T</code> object.
     *
     * @param t
     * @return
     */
    public T create(T t);

    /**
     * Creates the <code>List<T></code> objects.
     *
     * @param ts
     * @return
     */
    public List<T> create(List<T> ts);

    /**
     * Returns the list of all <code>T</code> objects.
     *
     * @return
     */
    List<T> getAll();

    /**
     * Returns the <code>T</code> object by <code>id</code>.
     *
     * @param id
     * @return
     */
    T getById(final Long id);

    /**
     * Returns the pageable <code>T</code> object by <code>pageable</code> filter.
     *
     * @param filter
     * @return
     */
    public List<T> getByFilter(Filter filter);

    /**
     * Returns the pageable <code>T</code> object by <code>pageable</code> filter.
     *
     * @param pageable
     * @return
     */
    public Page<T> getByFilter(Filter filter, Pageable pageable);

    /**
     * Updates the <code>T</code> object.
     *
     * @param t
     * @return
     */
    public T update(T t);

    /**
     * Updates the <code>List<T></code> objects.
     *
     * @param ts
     * @return
     */
    public List<T> update(List<T> ts);

    /**
     * Deletes the object by <code>id</code>.
     *
     * @param id
     * @return
     */
    public T delete(Long id);

}
