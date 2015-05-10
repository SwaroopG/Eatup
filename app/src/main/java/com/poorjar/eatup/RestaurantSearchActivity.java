package com.poorjar.eatup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class RestaurantSearchActivity extends Activity {

    private ListView restaurantListView;
    private String[] stringArray;
    private ArrayAdapter restaurantItemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_search);


        stringArray = new String[10];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = "String " + i;
        }

        restaurantItemArrayAdapter = new RestaurantAdapter(this, stringArray);
        restaurantListView = (ListView) findViewById(R.id.restaurantView);
        restaurantListView.setAdapter(restaurantItemArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
