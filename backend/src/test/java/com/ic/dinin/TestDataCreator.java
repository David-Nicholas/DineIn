package com.ic.dinin;

import com.ic.dinin.domain.Restaurant;
import jakarta.persistence.EntityManager;

public class TestDataCreator {

    public static Restaurant createRestaurant(EntityManager em, String name, String description){
        Restaurant buyer = new Restaurant(name, description);
        em.persist(buyer);

        return buyer;
    }

    public static void createRestaurantsData(EntityManager em){

        Restaurants.restaurant1 = createRestaurant(em, "Peppers", "mancare");
        Restaurants.restaurant2 = createRestaurant(em, "MBistro", "mancare");
        Restaurants.restaurant3 = createRestaurant(em, "SteakHouse", "mancare");
        Restaurants.restaurant4 = createRestaurant(em, "Casa Bunicii", "mancare");
        Restaurants.restaurant5 = createRestaurant(em, "Nora", "mancare");
    }

    public static class Restaurants {
        public static Restaurant restaurant1;
        public static Restaurant restaurant2;
        public static Restaurant restaurant3;
        public static Restaurant restaurant4;
        public static Restaurant restaurant5;
    }

}