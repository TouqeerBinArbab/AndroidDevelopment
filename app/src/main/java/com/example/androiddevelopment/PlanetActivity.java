package com.example.androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Objects;

public class PlanetActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static MyPlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        // 1- AdapterView: a ListView
        listView  = findViewById(R.id.planetListView);

        // 2- Data Source: ArrayList<Planet>
        planetsArrayList = new ArrayList<>();

        Planet planet3 = new Planet("Earth","1 Moon",R.drawable.earth);
        Planet planet1 = new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0 Moons", R.drawable.venus);

        Planet planet4 = new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "83 Moons", R.drawable.saturn);

        Planet planet7 = new Planet("Uranus", "27 Moons", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "14 Moons", R.drawable.neptune);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);
        planetsArrayList.add(planet5);
        planetsArrayList.add(planet6);
        planetsArrayList.add(planet7);
        planetsArrayList.add(planet8);


        // Adapter:
        adapter = new MyPlanetAdapter(planetsArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        // Handling Click Events

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(PlanetActivity.this, "Planet Name: " + Objects.requireNonNull(adapter.getItem(i)).getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}