package com.rslakra.melody.iws.framework.controller.web;

import com.rslakra.appsuite.core.BeanUtils;
import com.rslakra.appsuite.spring.exception.InvalidRequestException;
import com.rslakra.melody.iws.framework.filter.Filter;
import org.springframework.ui.Model;

import java.util.Optional;

/**
 * @author Rohtash Lakra
 * @created 10/15/21 6:11 PM
 */
public interface WebController<T> {

    /**
     * Saves the <code>t</code> object.
     *
     * @param t
     * @return
     */
    public String save(T t);

    /**
     * Returns the list of <code>T</code> objects.
     *
     * @param model
     * @return
     */
    public String getAll(Model model);

    /**
     * Filters the list of <code>T</code> objects.
     *
     * @param model
     * @param filter
     * @return
     */
    public String filter(Model model, Filter filter);

    /**
     * @param id
     */
    public default void validate(Optional<Long> id) {
        if (BeanUtils.isNull(id) || !id.isPresent()) {
            throw new InvalidRequestException("The ID should provide!");
        }
    }

    /**
     * Create the new object or Updates the object with <code>id</code>.
     *
     * @param model
     * @param id
     * @return
     */
    public String editObject(Model model, Optional<Long> id);

    /**
     * Deletes the object with <code>id</code>.
     *
     * @param model
     * @param id
     * @return
     */
    public String delete(Model model, Optional<Long> id);

}
