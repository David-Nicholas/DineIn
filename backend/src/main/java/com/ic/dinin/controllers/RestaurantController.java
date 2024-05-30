package com.ic.dinin.controllers;

import com.ic.dinin.domain.Restaurant;
import com.ic.dinin.dto.RestaurantDTO;
import com.ic.dinin.repositories.RestaurantRepository;
import com.ic.dinin.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ModelMapper modelMapper;

    public RestaurantController(RestaurantService restaurantService, ModelMapper modelMapper) {
        this.restaurantService = restaurantService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/restaurants")
    public Stream<RestaurantDTO> getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants.stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDTO.class));
    }

    @GetMapping("/restaurants/{id}")
    public  RestaurantDTO getRestaurant(@PathVariable long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }
}
