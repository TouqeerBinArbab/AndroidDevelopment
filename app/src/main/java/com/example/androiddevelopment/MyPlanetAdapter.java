package com.example.androiddevelopment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyPlanetAdapter extends ArrayAdapter<Planet> {

    // Using Custom Layout --> MyPlanetAdapter
    // Using Custom Layout --> extends ArrayAdaper<Planet>

    private ArrayList<Planet> planetArrayList;
    private final Context context;
    public MyPlanetAdapter( ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.planet_item, planetsArrayList);
        this.planetArrayList = planetsArrayList;
        this.context = context;
    }

    // View Holder class: used to cache references to the views within
    //                    an item layout, so that they don't need to be
    //                    repeatedly looked up during scrolling

    private static class MyViewHolder {
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    // getView(): used to create and return a view for a specific item in the list.


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1- Get the planet object for the current position
        Planet planets = getItem(position);

        // 2- Inflate Layout
        MyViewHolder myViewHolder = null;
        View result = null;

        if(convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.planet_item, parent, false);

            // Finding Views;
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moon_count_text);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.moon_image);

            result = convertView;
            convertView.setTag(myViewHolder);
        } else {
            // the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getPlanetImage());
        return result;
    }
}
