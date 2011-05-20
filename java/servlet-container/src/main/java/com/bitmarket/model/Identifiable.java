package com.bitmarket.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@SuppressWarnings({"UnusedDeclaration"})
@MappedSuperclass
public class Identifiable {
    private long id;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
