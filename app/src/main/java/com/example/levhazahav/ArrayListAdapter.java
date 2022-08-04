package com.example.levhazahav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAdapter extends ArrayAdapter {
    public ArrayListAdapter(Context context, ArrayList<elderlyHouse> elderlyHouses) {
        super(context, 0, elderlyHouses);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        elderlyHouse elderlyHouse = (com.example.levhazahav.elderlyHouse) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_group, parent, false);
        }
        // Lookup view for data population
        TextView tvEldHouseName = (TextView) convertView.findViewById(R.id.tvEldHouseName);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);
        ImageView imStars = (ImageView) convertView.findViewById(R.id.imStars);

        // Populate the data into the template view using the data object
        tvEldHouseName.setText(elderlyHouse.getEldHouseName());
        tvLocation.setText(elderlyHouse.getAddress());

        if (elderlyHouse.getStarRating() == 1)
        {
            imStars.setImageResource(R.drawable.one_stars);
        }
        if (elderlyHouse.getStarRating() == 2)
        {
            imStars.setImageResource(R.drawable.two_stars);
        }
        if (elderlyHouse.getStarRating() == 3)
        {
            imStars.setImageResource(R.drawable.three_stars);
        }
        if (elderlyHouse.getStarRating() == 4)
        {
            imStars.setImageResource(R.drawable.four_stars);
        }
        if (elderlyHouse.getStarRating() == 5)
        {
            imStars.setImageResource(R.drawable.five_stars);
        }
        // Return the completed view to render on screen
        return convertView;
    }



}