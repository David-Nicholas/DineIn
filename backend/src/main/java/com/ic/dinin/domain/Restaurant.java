package com.ic.dinin.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = Restaurant.TABLE_NAME)
public class Restaurant extends BaseEntity {

    public static final String TABLE_NAME = "RESTAURANT";

    interface Columns{
        String NAME = "NAME";
        String DESCRIPTION = "DESCRIPTION";
    }

    protected Restaurant(){

    }

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Column(name = Columns.NAME, nullable = false)
    public String name;

    @Column(name = Columns.DESCRIPTION)
    public String description;
}
