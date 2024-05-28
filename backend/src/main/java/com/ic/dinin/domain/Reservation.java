package com.ic.dinin.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = Reservation.TABLE_NAME)
public class Reservation extends BaseEntity {
    public static final String TABLE_NAME = "RESERVATION";

    interface Columns{
        String DATE_TIME = "DATE_TIME";
        String RESTAURANT_TABLE_ID = "RESTAURANT_TABLE_ID";
    }

    @Column(name = Columns.DATE_TIME, nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Columns.RESTAURANT_TABLE_ID, foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (" + Columns.RESTAURANT_TABLE_ID + ") REFERENCES " + RestaurantTable.TABLE_NAME + " (" + BaseEntity.ID + ")  ON DELETE SET NULL"))
    private RestaurantTable table;

    protected Reservation(){}

    public Reservation(RestaurantTable table){
        this.dateTime = LocalDateTime.now();
        this.table = table;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public RestaurantTable getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "dateTime=" + dateTime +
                ", table=" + table +
                '}';
    }
}
