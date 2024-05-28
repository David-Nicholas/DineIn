package com.ic.dinin.dto;

import com.ic.dinin.domain.RestaurantTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private LocalDateTime dateTime;
    private RestaurantTableDTO table;
}
