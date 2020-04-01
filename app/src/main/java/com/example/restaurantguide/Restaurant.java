package com.example.restaurantguide;


import java.util.ArrayList;


public class Restaurant {
    private String name;
    private String type;
    private String location;
    private double rating;
    private String symbol;
    private String address;
    private int mImageResource;
    private String overview;
    public Restaurant() {
    }

    public Restaurant(String name, String type, String location, double rating, String symbol, int imageResource, String address, String overview) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.rating = rating;
        this.symbol = symbol;
        this.mImageResource = imageResource;
        this.address = address;
        this.overview = overview;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String Location){
        this.location = location;
    }
    public double getRating(){
        return rating;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }



    public int getImageResource() {
        return mImageResource;
    }

    public static ArrayList<Restaurant> getRestaurant() {
        ArrayList<Restaurant> restaurant = new ArrayList<>();
        restaurant.add(new Restaurant("Matsusaka", "Japanese", "Haymarket", 5, "MB", R.drawable.meat, " Level 1/90 Hay St, Haymarket", "A new restaurant concept with two Japanese restaurants in one!  A ramen shop at lunch and a yakiniku BBQ restaurant at night!" ));
        restaurant.add(new Restaurant("Grill'D", "Western", "Sydney CBD", 4, "GD", R.drawable.burger, "World Square Centre, George St, Sydney","Cool place for burgers & sliders made from carefully sourced produce, plus low-carb options."));
        restaurant.add(new Restaurant("Kogi Korean BBQ", "Korean", "1909 Dining Precint", 4.8, "KG", R.drawable.korean, "Level 3 Market City, Haymarket","KOGI Korean BBQ brings the artisan way of doing Korean BBQ. It mixes both premium quality meats with traditional techniques of preparation to serve a Korean BBQ experience like no other."));
        restaurant.add(new Restaurant("Sushi Hotaru", "Japanese", "The Galeries", 4.5, "SH", R.drawable.sushi, "500 George St, Sydney", "Japanese dishes selected from the conveyor belt or ordered via touch screen in a narrow, sleek room." ));
        restaurant.add(new Restaurant("Anita", "Dessert", "Broadway", 4.9, "ANT", R.drawable.icecream, "Central Park Mall, 28, Broadway", "Hip, open-late nook offering Italian-style gelato & frozen yoghurt in various flavours, plus coffee."));
        restaurant.add(new Restaurant("Mascot Kebabs", "Middle-East", "Mascot", 4.1, "MKB", R.drawable.kebab, "950 Botany Rd, Mascot","Pide, grilled meats, salads and chips in a no-frills counter-serve venue with streetside tables."));
        restaurant.add(new Restaurant("WeWok", "Chinese", "Kingsford", 4.3, "WW", R.drawable.dumpling, "426 Anzac Parade, Kingsford","Traditional mains like Shandong chicken, in a cheery, glass-fronted locale with a buzzing vibe."));
        restaurant.add(new Restaurant("Isabella", "Italian", "Randwick", 4.3, "ISB", R.drawable.italian,"183 Alison Rd, Randwick","Old-school brekkies, plus pasta, steak & seafood, in a low-key Italian spot with colorful decor." ));
        restaurant.add(new Restaurant("Munich Brauhaus", "German", "The Rocks", 4.6, "MBR", R.drawable.german,"33 Playfair St &, Argyle St, The Rocks","Festive beer hall with live music, serving imported beers and German dishes like pork schnitzel.\n"));
        restaurant.add(new Restaurant("Its Time For Thai", "Thai", "Kingsford", 5, "ITFT", R.drawable.thai, "2/309 Anzac Parade, Kingsford","Smart Thai eatery with colourful light shades serving classic curries, BBQ & stir-fries."));
        return restaurant;
    }
    public static Restaurant searchRestaurant (String symbol){

        ArrayList<Restaurant> restaurantArrayList = getRestaurant();

        Restaurant myRestaurant = restaurantArrayList.get(0);

        if(symbol.equals("MB")){
            myRestaurant = restaurantArrayList.get(0);
        }
        if (symbol.equals("GD")){
            myRestaurant = restaurantArrayList.get(1);
        }
        if(symbol.equals("KG")){
            myRestaurant = restaurantArrayList.get(2);
        }
        if(symbol.equals("SH")){
            myRestaurant = restaurantArrayList.get(3);
        }
        if(symbol.equals("ANT")){
            myRestaurant = restaurantArrayList.get(4);
        }
        if(symbol.equals("MKB")){
            myRestaurant = restaurantArrayList.get(5);
        }
        if(symbol.equals("WW")){
            myRestaurant = restaurantArrayList.get(6);
        }
        if(symbol.equals("ISB")){
            myRestaurant = restaurantArrayList.get(7);
        }
        if(symbol.equals("MBR")){
            myRestaurant = restaurantArrayList.get(8);
        }
        if(symbol.equals("ITFT")){
            myRestaurant = restaurantArrayList.get(9);
        }
        return myRestaurant;

    }
    public static ArrayList<Restaurant> CreateRestaurant (ArrayList<Restaurant> restaurant) {

        ArrayList<Restaurant> myRestaurant = getRestaurant();

        restaurant.addAll(myRestaurant);

        return restaurant;
    }



}


