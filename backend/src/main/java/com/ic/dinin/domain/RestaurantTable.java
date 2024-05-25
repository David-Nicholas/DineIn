package com.ic.dinin.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = RestaurantTable.TABLE_NAME)
public class RestaurantTable extends BaseEntity {
    public static final String TABLE_NAME = "RESTAURANT_TABLE";

    interface Columns{
        String RESTAURANT_TABLE_ID = "RESTAURANT_TABLE_ID";
        String SEATS = "SEATS";
    }

    protected RestaurantTable(){

    }

    public RestaurantTable(int seats) {
        this.seats = seats;
    }

    @Column(name = Columns.SEATS, nullable = false)
    private int seats;

    public void updateTable(int seats){
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "seats=" + seats +
                '}';
    }
}
