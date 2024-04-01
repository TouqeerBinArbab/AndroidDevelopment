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

public class AppCustomAdapter extends ArrayAdapter<App> {
    private ArrayList<App> appArrayList;
    private final Context context;

    public AppCustomAdapter( ArrayList<App> appArrayList, Context context) {
        super(context, R.layout.app_item, appArrayList);
        this.appArrayList = appArrayList;
        this.context = context;
    }

    private static class MyViewHolder {
        TextView appName;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1- Get the planet object for the current position
        App app = getItem(position);

        // 2- Inflate Layout
        AppCustomAdapter.MyViewHolder myViewHolder = null;
        View result = null;

        if(convertView == null) {
            myViewHolder = new AppCustomAdapter.MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.app_item, parent, false);

            // Finding Views;
            myViewHolder.appName = (TextView) convertView.findViewById(R.id.app_name);

            result = convertView;
            convertView.setTag(myViewHolder);
        } else {
            // the view is recycled
            myViewHolder = (AppCustomAdapter.MyViewHolder) convertView.getTag();
            result = convertView;
        }

        myViewHolder.appName.setText(app.getAppName());

        return result;
    }




}
