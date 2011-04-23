package com.mashlife.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@SuppressWarnings({"UnusedDeclaration"})
@MappedSuperclass
public class Identifiable {
    private Long id;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
