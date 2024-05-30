package com.ic.dinin.services;

import com.ic.dinin.domain.Reservation;
import com.ic.dinin.domain.Restaurant;
import com.ic.dinin.domain.RestaurantTable;
import com.ic.dinin.repositories.ReservationRepository;
import com.ic.dinin.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RestaurantRepository restaurantRepository;

    public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository) {
        this.reservationRepository = reservationRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Reservation createReservation(float reservationDuration, LocalDateTime startReservationTime, long restaurantId, int numberOfPeople) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        List<RestaurantTable> tables = restaurant.getRestaurantTables().stream().toList();

        Set<RestaurantTable> availableTables = findAvailableTables(tables, startReservationTime, reservationDuration, numberOfPeople);

        if (!availableTables.isEmpty()) {
            Reservation reservation = new Reservation(startReservationTime, reservationDuration, availableTables, numberOfPeople);
            return reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("No available tables found for the specified time and duration");
        }
    }

    private Set<RestaurantTable> findAvailableTables(List<RestaurantTable> tables, LocalDateTime start, float duration, int numberOfPeople) {
        LocalDateTime end = start.plusMinutes((long) (duration * 60));

        List<RestaurantTable> availableTables = tables.stream()
                .filter(table -> isTableAvailable(table, start, end))
                .collect(Collectors.toList());

        return findTablesCombination(availableTables, numberOfPeople);
    }

    private boolean isTableAvailable(RestaurantTable table, LocalDateTime start, LocalDateTime end) {
        List<Reservation> reservations = reservationRepository.findAllByTablesContaining(table);

        for (Reservation reservation : reservations) {
            LocalDateTime reservationEnd = reservation.getStartReservationTime().plusMinutes((long) (reservation.getReservationDuration() * 60));
            if (start.isBefore(reservationEnd) && end.isAfter(reservation.getStartReservationTime())) {
                return false;
            }
        }
        return true;
    }

    private Set<RestaurantTable> findTablesCombination(List<RestaurantTable> availableTables, int numberOfPeople) {
        Set<RestaurantTable> selectedTables = new HashSet<>();
        int seatsSum = 0;

        for (RestaurantTable table : availableTables) {
            if (seatsSum >= numberOfPeople) {
                break;
            }
            selectedTables.add(table);
            seatsSum += table.getSeats();
        }

        if (seatsSum >= numberOfPeople) {
            return selectedTables;
        } else {
            return Collections.emptySet();
        }
    }
}
