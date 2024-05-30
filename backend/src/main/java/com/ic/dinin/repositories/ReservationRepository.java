package com.ic.dinin.repositories;

import com.ic.dinin.domain.Reservation;
import com.ic.dinin.domain.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByTablesContaining(RestaurantTable table);
}
