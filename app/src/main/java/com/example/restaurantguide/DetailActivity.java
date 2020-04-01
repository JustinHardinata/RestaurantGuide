package com.example.restaurantguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {
    private TextView name;
    private ImageView banner;
    private TextView rating;
    private ImageView star;
    private TextView address;
    private TextView overview;


    private final ArrayList<Restaurant> restaurant = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView name = findViewById(R.id.name);
        TextView rating = findViewById(R.id.rating);
        TextView address = findViewById(R.id.address);
        TextView overview = findViewById(R.id.overview);
        ImageView banner = findViewById(R.id.photo);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        final Restaurant restaurant = Restaurant.searchRestaurant(message);

        name.setText(restaurant.getName());
        address.setText(restaurant.getAddress());
        rating.setText(restaurant.getRating() + " Stars");
        overview.setText(restaurant.getOverview());
        banner.setImageResource(restaurant.getImageResource());



    }


}