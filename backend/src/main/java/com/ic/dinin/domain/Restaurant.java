package com.ic.dinin.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Restaurant.TABLE_NAME)
public class Restaurant extends BaseEntity {

    public static final String TABLE_NAME = "RESTAURANT";

    interface Columns{
        String NAME = "NAME";
        String DESCRIPTION = "DESCRIPTION";
        String MENU_URL = "MENU_URL";
        String PHONE_NUMBER = "PHONE_NUMBER";
        String COORDINATE_X = "COORDINATE_X";
        String COORDINATE_Y = "COORDINATE_Y";
        String IMAGE_URL = "IMAGE_URL";
    }

    protected Restaurant(){}

    public Restaurant(String name, String description, MapCoordinates mapCoordinates, String imageUrl, String menuUrl, String phoneNumber) {
        this.name = name;
        this.description = description;
        this.mapCoordinates = mapCoordinates;
        this.imageUrl = imageUrl;
        this.menuUrl = menuUrl;
        this.phoneNumber = phoneNumber;
        this.restaurantTables = new HashSet<>();
    }

    @Column(name = Columns.NAME, nullable = false, unique = true)
    private String name;

    @Column(name = Columns.DESCRIPTION, nullable = false)
    private String description;

    @Column(name = Columns.IMAGE_URL, nullable = false)
    private String imageUrl;

    @Column(name = Columns.MENU_URL, nullable = false)
    private String menuUrl;

    @Column(name = Columns.PHONE_NUMBER, nullable = false)
    private String phoneNumber;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "coordinate_x", column = @Column(name = Columns.COORDINATE_X, nullable = false)),
        @AttributeOverride(name = "coordinate_y", column = @Column(name = Columns.COORDINATE_Y, nullable = false)),
    })
    private MapCoordinates mapCoordinates;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = RestaurantTable.Columns.RESTAURANT_ID, foreignKey = @ForeignKey(foreignKeyDefinition =
            "FOREIGN KEY (" + RestaurantTable.Columns.RESTAURANT_ID + ") REFERENCES " + RestaurantTable.TABLE_NAME + " (" + BaseEntity.ID + ")  ON DELETE CASCADE"))
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

    public String getMenuUrl() {
        return menuUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mapCoordinates=" + mapCoordinates +
                ", restaurantTables=" + restaurantTables +
                '}';
    }
}
