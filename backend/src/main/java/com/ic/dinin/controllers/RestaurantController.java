package com.ic.dinin.controllers;

import com.ic.dinin.domain.Restaurant;
import com.ic.dinin.repositories.RestaurantRepository;
import com.ic.dinin.services.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantService restaurantService, RestaurantRepository restaurantRepository) {
        this.restaurantService = restaurantService;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getCategories() {
        List<Restaurant> restaurants = restaurantService.getCategories();
        return ResponseEntity.ok(restaurants);
    }
}
