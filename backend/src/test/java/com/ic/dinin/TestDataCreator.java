package com.ic.dinin;

import com.ic.dinin.domain.MapCoordinates;
import com.ic.dinin.domain.Restaurant;
import jakarta.persistence.EntityManager;

public class TestDataCreator {

    public static Restaurant createRestaurant(EntityManager em, String name, String description, MapCoordinates mapCoordinates){
        Restaurant buyer = new Restaurant(name, description, mapCoordinates);
        em.persist(buyer);

        return buyer;
    }

    public static void createRestaurantsData(EntityManager em){

        Restaurants.restaurant1 = createRestaurant(em, "Peppers", "mancare", new MapCoordinates(45.75815142782663f, 21.226471371681047f));
        Restaurants.restaurant2 = createRestaurant(em, "MBistro", "mancare", new MapCoordinates(1,2));
        Restaurants.restaurant3 = createRestaurant(em, "SteakHouse", "mancare", new MapCoordinates(1,2));
        Restaurants.restaurant4 = createRestaurant(em, "Casa Bunicii", "mancare", new MapCoordinates(1,2));
        Restaurants.restaurant5 = createRestaurant(em, "Nora", "mancare", new MapCoordinates(1,2));
    }

    public static class Restaurants {
        public static Restaurant restaurant1;
        public static Restaurant restaurant2;
        public static Restaurant restaurant3;
        public static Restaurant restaurant4;
        public static Restaurant restaurant5;
    }

}