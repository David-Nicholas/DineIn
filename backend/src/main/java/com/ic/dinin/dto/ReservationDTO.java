package com.ic.dinin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private LocalDateTime startReservationTime;
    private Set<RestaurantTableDTO> tables;
    private float reservationDuration;
    private int numberOfPeople;
}
