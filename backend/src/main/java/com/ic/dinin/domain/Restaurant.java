package com.ic.dinin.domain;

import jakarta.persistence.*;

@Entity
@Table(name = Restaurant.TABLE_NAME)
public class Restaurant extends BaseEntity {

    public static final String TABLE_NAME = "RESTAURANT";

    interface Columns{
        String NAME = "NAME";
        String DESCRIPTION = "DESCRIPTION";
        String COORDINATE_X = "COORDINATE_X";
        String COORDINATE_Y = "COORDINATE_Y";
    }

    protected Restaurant(){

    }

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Column(name = Columns.NAME, nullable = false)
    private String name;

    @Column(name = Columns.DESCRIPTION)
    private String description;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "coordinate_x", column = @Column(name = Columns.COORDINATE_X, nullable = false)),
        @AttributeOverride(name = "coordinate_y", column = @Column(name = Columns.COORDINATE_Y, nullable = false)),
    })
    private MapCoordinates mapCoordinates;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
