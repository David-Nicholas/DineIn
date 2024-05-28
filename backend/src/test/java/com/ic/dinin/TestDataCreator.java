package com.ic.dinin;

import com.ic.dinin.domain.MapCoordinates;
import com.ic.dinin.domain.Restaurant;
import jakarta.persistence.EntityManager;

public class TestDataCreator {

    public static Restaurant createRestaurant(EntityManager em, String name, String description, MapCoordinates mapCoordinates, String imageUrl){
        Restaurant buyer = new Restaurant(name, description, mapCoordinates, imageUrl);
        em.persist(buyer);

        return buyer;
    }

    public static void createRestaurantsData(EntityManager em){

        Restaurants.restaurant1 = createRestaurant(em, "Peppers", "mancare", new MapCoordinates(1,2), "restaurant.jpeg");
        Restaurants.restaurant2 = createRestaurant(em, "MBistro", "mancare", new MapCoordinates(1,2), "restaurant.jpeg");
        Restaurants.restaurant3 = createRestaurant(em, "SteakHouse", "mancare", new MapCoordinates(1,2), "restaurant.jpeg");
        Restaurants.restaurant4 = createRestaurant(em, "Casa Bunicii", "mancare", new MapCoordinates(1,2), "restaurant.jpeg");
        Restaurants.restaurant5 = createRestaurant(em, "Nora", "mancare", new MapCoordinates(1,2), "restaurant.jpeg");
    }

    public static class Restaurants {
        public static Restaurant restaurant1;
        public static Restaurant restaurant2;
        public static Restaurant restaurant3;
        public static Restaurant restaurant4;
        public static Restaurant restaurant5;
    }

}