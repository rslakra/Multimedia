package com.rslakra.melody.iws.contact.persistence.entity;

import com.rslakra.appsuite.core.ToString;
import com.rslakra.melody.iws.account.persistence.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Rohtash Lakra
 * @created 5/25/22 4:56 PM
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact extends Person {

    @Column(name = "phone")
    private String phone;

    @Column(name = "query")
    private String query;

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Contact.class)
            .add("email", getEmail())
            .add("firstName", getFirstName())
            .add("middleName", getMiddleName())
            .add("lastName", getLastName())
            .add("phone", getPhone())
            .add("query", getQuery())
            .toString();
    }
}

