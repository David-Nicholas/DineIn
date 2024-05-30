package com.ic.dinin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationInputDTO {
    private LocalDateTime startReservationTime;
    private float reservationDuration;
    private int numberOfPeople;
    private long restaurantId;
}
