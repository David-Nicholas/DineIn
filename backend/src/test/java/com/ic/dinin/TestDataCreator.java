package com.ic.dinin;

import com.ic.dinin.domain.MapCoordinates;
import com.ic.dinin.domain.Reservation;
import com.ic.dinin.domain.Restaurant;
import com.ic.dinin.domain.RestaurantTable;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestDataCreator {

    private static Restaurant createRestaurant(EntityManager em, String name, String description, String menuUrl, String phoneNumber, MapCoordinates mapCoordinates, String imageUrl){
        Restaurant restaurant = new Restaurant(name, description, mapCoordinates, imageUrl, menuUrl, phoneNumber);
        em.persist(restaurant);
        return restaurant;
    }

    private static RestaurantTable createTable(EntityManager em, int seats){
        RestaurantTable restaurantTable = new RestaurantTable(seats);
        em.persist(restaurantTable);
        return restaurantTable;
    }

    public static void createRestaurantTablesData(EntityManager em){
        Tables.restaurantTable1 = createTable(em, 4);
        Tables.restaurantTable2 = createTable(em, 2);
        Tables.restaurantTable3 = createTable(em, 6);
        Tables.restaurantTable4 = createTable(em, 4);
        Tables.restaurantTable5 = createTable(em, 8);
        Tables.restaurantTable6 = createTable(em, 2);
        Tables.restaurantTable7 = createTable(em, 2);
        Tables.restaurantTable8 = createTable(em, 4);
        Tables.restaurantTable9 = createTable(em, 6);
        Tables.restaurantTable10 = createTable(em, 2);
    }

    public static void createRestaurantsData(EntityManager em){

        Restaurants.restaurant1 = createRestaurant(em, "Peppers", "Restaurant", "https://restaurantpepper.ro/meniu/", "+40 720 408 250", new MapCoordinates(45.75815142782663f, 21.226471371681047f), "pepper.png");
        Restaurants.restaurant2 = createRestaurant(em, "Taverna Racilor", "Restaurant cu fructe de mare", "https://tavernaracilor.ro/meniu-qr/", "0729 825 528", new MapCoordinates(45.766531005475976f, 21.22982406694069f), "taverna_racilor.png");
        Restaurants.restaurant3 = createRestaurant(em, "Fenice Palas Timisoara", "Restaurant", "https://timisoara.fenicepalas.ro/wp-content/uploads/2020/08/fenice_tm_menu.pdf", "0770 352 352", new MapCoordinates(45.765399415259054f, 21.227762903545052f), "fenice.jpeg");
        Restaurants.restaurant4 = createRestaurant(em, "C House Milano", "Restaurant", "https://chousemilanoromania.ro/meniu/", "+40764246873", new MapCoordinates(45.765566408740085f, 21.22761276530506f), "c_house_milano.jpeg");
        Restaurants.restaurant5 = createRestaurant(em, "Enjoy Sushi", "Restaurant cu specific asiatic", "", "0753 824 583", new MapCoordinates(45.76599847433149f, 21.229787748865927f), "enjoy_sushi.jpeg");
        Restaurants.restaurant6 = createRestaurant(em, "Kai", "Restaurant", "https://kai.ro/ro/meniu", "+40 787 711 005", new MapCoordinates(45.76539767938891f, 21.229741338506873f), "kai.jpeg");
        Restaurants.restaurant7 = createRestaurant(em, "Riyo Wok & Sushi", "Restaurant cu sushi", "https://riyosushi.ro/meniu/", "+40 758 091 091", new MapCoordinates(45.75818069560485f, 21.22618693471867f), "riyo_wok.jpeg");
        Restaurants.restaurant8 = createRestaurant(em, "Locanda Del Corso", "Restaurant cu specific italian", "https://locandadelcorso.ro/ro/meniu", "+40 256 282 282", new MapCoordinates(45.757565911900386f, 21.226108736296684f), "locanda_del_corso.jpeg");
        Restaurants.restaurant9 = createRestaurant(em, "EL Maguey", "Restaurant cu specific mexican", "https://elmagueymexican.com/menu/", "0723 436 780", new MapCoordinates(45.756948939366694f, 21.226702872128506f), "el_maguey.jpeg");
        Restaurants.restaurant10 = createRestaurant(em, "Jack's Bistro", "Bistro", "https://qr.bitsandbites.ro/mobile/544Q8AEw5HVWymI8DyQH", "07 432 324 432", new MapCoordinates(45.75702284789444f, 21.22776218407671f), "jacks_bistro.jpeg");
        Restaurants.restaurant11 = createRestaurant(em, "Lloyd", "Restaurant", "https://lloydtimisoara.ro/meniu/", "07 321 321 321", new MapCoordinates(45.753494618837344f, 21.225197264550566f), "lloyd.png");
        Restaurants.restaurant12 = createRestaurant(em, "Pizza Joy - Rooftop", "Pizzerie", "https://online.pizzajoy.ro/#/menu", "0731 364 824", new MapCoordinates(45.75471775470736f, 21.22677267968644f), "pizza_joy.jpeg");
        Restaurants.restaurant13 = createRestaurant(em, "Stradivarius", "Restaurant", "https://www.stradivariustm.ro/?page_id=10", "+40 356 452158", new MapCoordinates(45.758141971661296f, 21.228069495069832f), "stradivarius.jpeg");
        Restaurants.restaurant14 = createRestaurant(em, "Balkan Bistro Timisoara", "Restaurant cu specific sârbesc", "https://balkanbistro.ro/meniu/", "+40 744 601 456", new MapCoordinates(45.757644440918874f, 21.227985209128665f), "balkan_bistro.jpeg");
        Restaurants.restaurant15 = createRestaurant(em, "La Pinochio", "Pizzerie", "https://clatite-pinochio.ro/meniu/", "200721153855", new MapCoordinates(45.75748703562902f, 21.228653006614596f), "la_pinochio.jpeg");
        Restaurants.restaurant16 = createRestaurant(em, "Restaurant Merlot", "Restaurant", "https://www.restaurant-merlot.ro/files/meniu2023_v02.pdf", "+40356177247", new MapCoordinates(45.75683409629608f, 21.241930154086894f), "merlot.jpeg");
        Restaurants.restaurant17 = createRestaurant(em, "MGM Bastion Pub & Food", "Pub", "", "0760 672 387", new MapCoordinates(45.75661031447018f, 21.23266479849883f), "mgm.jpeg");
        Restaurants.restaurant18 = createRestaurant(em, "Rivière Brasseried", "Restaurant", "https://riviere.ro/meniu-restaurant/", "0746 095 573", new MapCoordinates(45.74902882628068f, 21.22635875967253f), "riviere_brasseried.jpeg");
        Restaurants.restaurant19 = createRestaurant(em, "Grădina Bănaţeană", "Restaurant", "https://www.gradinabanateana.ro/meniu/", "0725 725 666", new MapCoordinates(45.74886282482162f, 21.22642310733398f), "gradina_banateana.png");
        Restaurants.restaurant20 = createRestaurant(em, "Vineri 15", "Restaurant", "http://www.vineri15.ro/", "0721 202 821", new MapCoordinates(45.748279545818626f, 21.230204454678606f), "vineri15.jpeg");
        Restaurants.restaurant21 = createRestaurant(em, "Pizza Napoleon", "Pizzerie", "https://pizzavero.ro/produs/pizza-napoletana/", "0256 282 121", new MapCoordinates(45.749821214818056f, 21.24102784467266f), "pizza_napoleon.jpeg");
        Restaurants.restaurant22 = createRestaurant(em, "Restaurant Dinar", "Restaurant", "https://restaurantdinar.ro/wp-content/uploads/2024/03/Dinar-Menu_2024-1.pdf", "0728 116 230", new MapCoordinates(45.752386597450304f, 21.240265404850135f), "dinar.png");
    }

    private static Reservation createReservation(EntityManager em, Set<RestaurantTable> tables, LocalDateTime startReservationTime, float reservationDuration, int numberOfPeople, String phoneNumber){
        Reservation reservation = new Reservation(startReservationTime, reservationDuration, tables, numberOfPeople, phoneNumber);
        em.persist(reservation);
        return reservation;
    }

    public static void createReservationsData(EntityManager em){

        Reservations.reservation1 = createReservation(em, Collections.singleton(Tables.restaurantTable2), LocalDateTime.now(), 2f, 4, "0770157915");
        Reservations.reservation2 = createReservation(em, Collections.singleton(Tables.restaurantTable7), LocalDateTime.now(), 2f, 6, "0770157915");
        Reservations.reservation3 = createReservation(em, Collections.singleton(Tables.restaurantTable4), LocalDateTime.now(), 1f, 2, "0770157915");
        Reservations.reservation4 = createReservation(em, Collections.singleton(Tables.restaurantTable9), LocalDateTime.now(), 1f, 1, "0770157912");
    }

    public static void addRestaurantTables(EntityManager em){
        Restaurant restaurant1 = em.merge(Restaurants.restaurant1);
        Restaurant restaurant2 = em.merge(Restaurants.restaurant2);

        restaurant1.addTable(Tables.restaurantTable1);
        restaurant1.addTable(Tables.restaurantTable2);
        restaurant1.addTable(Tables.restaurantTable3);
        restaurant1.addTable(Tables.restaurantTable4);
        restaurant1.addTable(Tables.restaurantTable5);

        restaurant2.addTable(Tables.restaurantTable6);
        restaurant2.addTable(Tables.restaurantTable7);
        restaurant2.addTable(Tables.restaurantTable8);
        restaurant2.addTable(Tables.restaurantTable9);
        restaurant2.addTable(Tables.restaurantTable10);
    }

    public static class Restaurants {
        public static Restaurant restaurant1;
        public static Restaurant restaurant2;
        public static Restaurant restaurant3;
        public static Restaurant restaurant4;
        public static Restaurant restaurant5;
        public static Restaurant restaurant6;
        public static Restaurant restaurant7;
        public static Restaurant restaurant8;
        public static Restaurant restaurant9;
        public static Restaurant restaurant10;
        public static Restaurant restaurant11;
        public static Restaurant restaurant12;
        public static Restaurant restaurant13;
        public static Restaurant restaurant14;
        public static Restaurant restaurant15;
        public static Restaurant restaurant16;
        public static Restaurant restaurant17;
        public static Restaurant restaurant18;
        public static Restaurant restaurant19;
        public static Restaurant restaurant20;
        public static Restaurant restaurant21;
        public static Restaurant restaurant22;
    }

    public static class Tables {
        public static RestaurantTable restaurantTable1;
        public static RestaurantTable restaurantTable2;
        public static RestaurantTable restaurantTable3;
        public static RestaurantTable restaurantTable4;
        public static RestaurantTable restaurantTable5;
        public static RestaurantTable restaurantTable6;
        public static RestaurantTable restaurantTable7;
        public static RestaurantTable restaurantTable8;
        public static RestaurantTable restaurantTable9;
        public static RestaurantTable restaurantTable10;
    }

    public static class Reservations {
        public static Reservation reservation1;
        public static Reservation reservation2;
        public static Reservation reservation3;
        public static Reservation reservation4;
    }

}