package com.example.restaurantguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

//SUMMARY
//Functionality
//includes a recyclerview list of top 10 restaurants, designed with a cardview layout.
// Each card summarises the restaurant's location, type, and rating. Each cardview has matching image resource.
//includes a search function to filter restaurants based on user input located on the menu bar
//implemented onclick function based on position to direct users to related page after clicking a card.
// The related page, shows expanded information of the restaurant including its full address and overview.


public class MainActivity extends AppCompatActivity implements RestaurantListAdapter.OnNoteListener {
    public static final String EXTRA_MESSAGE = "com.example.restaurantguide.MESSAGE";
    private RecyclerView mRecyclerView;
    private RestaurantListAdapter mRestaurantListAdapter;
    private final ArrayList<Restaurant> mWordList = new ArrayList<>();
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Restaurant> myRestaurant = Restaurant.CreateRestaurant(mWordList);

        //Sets up handle to recyclerview
        mRecyclerView = findViewById(R.id.recyclerView);

        mRestaurantListAdapter = new RestaurantListAdapter(this, mWordList, this);

        //Connects adapter to recyclerview
        mRecyclerView.setAdapter(mRestaurantListAdapter);

        //Sets of default layout manager for the recyclerview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    //creates search query implemented on the menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.restaurant_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mRestaurantListAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    //sets up clicking function for position
    @Override
    public void onNoteClick(int position) {
        String symbol = getSymbol(position);
            launchActivity(symbol);

    }
    //method to handle launch of list
    public void launchActivity (String symbol) {
        Intent intent = new Intent (this, DetailActivity.class);
        String message = symbol;
        intent.putExtra(EXTRA_MESSAGE, symbol);
        startActivity(intent);
    }
    //defines which item to go to based on position clicked
    public String getSymbol (int position) {
        String symbol = "";

        if (position == 0) {
            symbol = "MB";
        }
        else if (position == 1) {
            symbol = "GD";
        }
        else if (position == 2) {
            symbol = "KG";
        }
        else if (position == 3) {
            symbol = "SH";
        }
        else if (position == 4) {
            symbol = "ANT";
        }
        else if (position == 5) {
            symbol = "MKB";
        }
        else if (position == 6) {
            symbol = "WW";
        }
        else if (position == 7) {
            symbol = "ISB";
        }
        else if (position == 8) {
            symbol = "MBR";
        }
        else if (position == 9) {
            symbol = "ITFT";
        }
        return symbol;
    }

}
