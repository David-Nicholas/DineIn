package com.ic.dinin.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = Reservation.TABLE_NAME)
public class Reservation extends BaseEntity {
    public static final String TABLE_NAME = "RESERVATION";

    public static final String JOIN_TABLE_NAME = "TABLE_RESERVATIONS";

    interface Columns{
        String RESERVATION_ID = "RESERVATION_ID";
        String DATE_TIME = "DATE_TIME";
        String RESTAURANT_TABLE_ID = "RESTAURANT_TABLE_ID";
        String RESERVATION_DURATION = "RESERVATION_DURATION";
        String NUMBER_OF_PEOPLE = "NUMBER_OF_PEOPLE";
        String PHONE_NUMBER = "PHONE_NUMBER";
        String RESERVATION_STATUS = "RESERVATION_STATUS";
    }

    @Column(name = Columns.DATE_TIME, nullable = false)
    private LocalDateTime startReservationTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = JOIN_TABLE_NAME,
            joinColumns = @JoinColumn(name = Columns.RESERVATION_ID),
            inverseJoinColumns = @JoinColumn(name = Columns.RESTAURANT_TABLE_ID))
    private Set<RestaurantTable> tables;

    @Column(name = Columns.RESERVATION_DURATION, nullable = false)
    private float reservationDuration;

    @Column(name = Columns.NUMBER_OF_PEOPLE, nullable = false)
    private int numberOfPeople;

    protected Reservation(){}

    public Reservation(LocalDateTime startReservationTime, float reservationDuration, Set<RestaurantTable> tables, int numberOfPeople){
        this.startReservationTime = startReservationTime;
        this.reservationDuration = reservationDuration;
        this.tables = tables;
        this.numberOfPeople = numberOfPeople;
    }

    public LocalDateTime getStartReservationTime() {
        return startReservationTime;
    }

    public Set<RestaurantTable> getTable() {
        return Collections.unmodifiableSet(tables);
    }

    public Set<RestaurantTable> getTables() {
        return tables;
    }

    public float getReservationDuration() {
        return reservationDuration;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "startReservationTime=" + startReservationTime +
                ", tables=" + tables +
                ", reservationDuration=" + reservationDuration +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }
}
