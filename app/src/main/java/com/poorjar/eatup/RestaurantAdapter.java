package com.poorjar.eatup;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Swaroop on 5/10/15.
 */
public class RestaurantAdapter extends ArrayAdapter {

    private LayoutInflater inflater;

    public RestaurantAdapter(Activity activity, String[] items) {
        super(activity, R.layout.row_restaurant, items);
        inflater = activity.getWindow().getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return inflater.inflate(R.layout.row_restaurant, parent, false);
    }

}