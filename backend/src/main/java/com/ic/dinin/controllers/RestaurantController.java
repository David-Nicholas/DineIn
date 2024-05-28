package com.ic.dinin.controllers;

import com.ic.dinin.domain.Restaurant;
import com.ic.dinin.dto.RestaurantDTO;
import com.ic.dinin.repositories.RestaurantRepository;
import com.ic.dinin.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantService restaurantService, ModelMapper modelMapper, RestaurantRepository restaurantRepository) {
        this.restaurantService = restaurantService;
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurants")
    public Stream<RestaurantDTO> getCategories() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants.stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDTO.class));
    }
}
