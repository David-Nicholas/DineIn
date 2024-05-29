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

        Restaurants.restaurant1 = createRestaurant(em, "Peppers", "mancare", new MapCoordinates(45.75815142782663f, 21.226471371681047f), "peppers.jpeg");
        Restaurants.restaurant2 = createRestaurant(em, "Taverna Racilor", "Restaurant cu fructe de mare", new MapCoordinates(45.766531005475976f, 21.22982406694069f), "peppers.jpeg");
        Restaurants.restaurant3 = createRestaurant(em, "Fenice Palas Timisoara", "Restaurant", new MapCoordinates(45.765399415259054f, 21.227762903545052f), "peppers.jpeg");
        Restaurants.restaurant4 = createRestaurant(em, "C House Milano", "Restaurant", new MapCoordinates(45.765566408740085f, 21.22761276530506f), "peppers.jpeg");
        Restaurants.restaurant5 = createRestaurant(em, "Enjoy Sushi", "Restaurant cu specific asiatic", new MapCoordinates(45.76599847433149f, 21.229787748865927f), "peppers.jpeg");
        Restaurants.restaurant6 = createRestaurant(em, "Kai", "Restaurant", new MapCoordinates(45.76539767938891f, 21.229741338506873f), "peppers.jpeg");
        Restaurants.restaurant7 = createRestaurant(em, "Riyo Wok & Sushi", "Restaurant cu sushi", new MapCoordinates(45.75818069560485f, 21.22618693471867f), "peppers.jpeg");
        Restaurants.restaurant8 = createRestaurant(em, "Locanda Del Corso", "Restaurant cu specific italian", new MapCoordinates(45.757565911900386f, 21.226108736296684f), "peppers.jpeg");
        Restaurants.restaurant9 = createRestaurant(em, "EL Maguey", "Restaurant cu specific mexican", new MapCoordinates(45.756948939366694f, 21.226702872128506f), "peppers.jpeg");
        Restaurants.restaurant10 = createRestaurant(em, "Jack's Bistro", "Bistro", new MapCoordinates(45.75702284789444f, 21.22776218407671f), "peppers.jpeg");
        Restaurants.restaurant11 = createRestaurant(em, "Lloyd", "Restaurant", new MapCoordinates(45.753494618837344f, 21.225197264550566f), "peppers.jpeg");
        Restaurants.restaurant12 = createRestaurant(em, "Pizza Joy - Rooftop", "Pizzerie", new MapCoordinates(45.75471775470736f, 21.22677267968644f), "peppers.jpeg");
        Restaurants.restaurant13 = createRestaurant(em, "Stradivarius", "Restaurant", new MapCoordinates(45.758141971661296f, 21.228069495069832f), "peppers.jpeg");
        Restaurants.restaurant14 = createRestaurant(em, "Balkan Bistro Timisoara", "Restaurant cu specific sârbesc", new MapCoordinates(45.757644440918874f, 21.227985209128665f), "peppers.jpeg");
        Restaurants.restaurant15 = createRestaurant(em, "La Pinochio", "Pizzerie", new MapCoordinates(45.75748703562902f, 21.228653006614596f), "peppers.jpeg");
        Restaurants.restaurant16 = createRestaurant(em, "Restaurant Merlot", "Restaurant", new MapCoordinates(45.75683409629608f, 21.241930154086894f), "peppers.jpeg");
        Restaurants.restaurant17 = createRestaurant(em, "MGM Bastion Pub & Food", "Pub", new MapCoordinates(45.75661031447018f, 21.23266479849883f), "peppers.jpeg");
        Restaurants.restaurant18 = createRestaurant(em, "Rivière Brasseried", "Restaurant", new MapCoordinates(45.74902882628068f, 21.22635875967253f), "peppers.jpeg");
        Restaurants.restaurant19 = createRestaurant(em, "Grădina Bănaţeană", "Restaurant", new MapCoordinates(45.74886282482162f, 21.22642310733398f), "peppers.jpeg");
        Restaurants.restaurant20 = createRestaurant(em, "Vineri 15", "Restaurant", new MapCoordinates(45.748279545818626f, 21.230204454678606f), "peppers.jpeg");
        Restaurants.restaurant21 = createRestaurant(em, "Pizza Napoleon", "Pizzerie", new MapCoordinates(45.749821214818056f, 21.24102784467266f), "peppers.jpeg");
        Restaurants.restaurant22 = createRestaurant(em, "Restaurant Dinar", "Restaurant", new MapCoordinates(45.752386597450304f, 21.240265404850135f), "peppers.jpeg");
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

}