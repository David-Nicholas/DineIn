package com.ic.dinin.dto;

import com.ic.dinin.domain.MapCoordinates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private long id;
    private String name;
    private String description;
    private MapCoordinates mapCoordinates;
    private Set<RestaurantTableDTO> restaurantTables;
}
