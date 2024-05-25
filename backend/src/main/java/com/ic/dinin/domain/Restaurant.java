package com.ic.dinin.domain;

import jakarta.persistence.*;

import java.util.Set;

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

    public Restaurant(String name, String description, MapCoordinates mapCoordinates) {
        this.name = name;
        this.description = description;
        this.mapCoordinates = mapCoordinates;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = RestaurantTable.Columns.RESTAURANT_TABLE_ID, foreignKey = @ForeignKey(foreignKeyDefinition =
            "FOREIGN KEY (" + RestaurantTable.Columns.RESTAURANT_TABLE_ID + ") REFERENCES " + RestaurantTable.TABLE_NAME + " (" + BaseEntity.ID + ")  ON DELETE CASCADE"))
    private Set<RestaurantTable> restaurantTables;

    public void addTable(RestaurantTable table){
        if(restaurantTables.contains(table)){
            throw new IllegalArgumentException("table already exists");
        }
        restaurantTables.add(table);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MapCoordinates getMapCoordinates() {
        return mapCoordinates;
    }

    public Set<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mapCoordinates=" + mapCoordinates +
                ", restaurantTables=" + restaurantTables +
                '}';
    }
}
