package com.example.androiddevelopment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button
            luckyAppBtn,
            greetingAppBtn,
            counterAppBtn,
            frenchAppBtn,
            listViewAppBtn,
            customListViewAppBtn,
            planetAppBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        luckyAppBtn = findViewById(R.id.lucky_app);
        greetingAppBtn = findViewById(R.id.greeting_app);
        counterAppBtn = findViewById(R.id.counter_app);
        frenchAppBtn = findViewById(R.id.french_app);
        listViewAppBtn = findViewById(R.id.list_view_app);
        customListViewAppBtn = findViewById(R.id.custom_list_view_app);
        planetAppBtn = findViewById(R.id.planet_app);

        luckyAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLuckyApp();
            }
        });

        greetingAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGreetingApp();
            }
        });

        counterAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCounterApp();
            }
        });

        frenchAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFrenchTeacherApp();
            }
        });

        listViewAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToListViewApp();
            }
        });

        customListViewAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCustomListViewApp();
            }
        });

        planetAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPlanetApp();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.action_home){
            Toast.makeText(this, "You selected Home", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.action_search) {
           Toast.makeText(this, "You selected Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToLuckyApp() {
        Intent intent = new Intent( getApplicationContext(), LuckyActivity.class);
        startActivity(intent);
    }

    public void goToGreetingApp() {
        Intent intent = new Intent( getApplicationContext(), GreetingActivity.class);
        startActivity(intent);
    }

    public void goToCounterApp() {
        Intent intent = new Intent( getApplicationContext(), CounterActivity.class);
        startActivity(intent);
    }

    public void goToFrenchTeacherApp() {
        Intent intent = new Intent( getApplicationContext(), FrenchTeacherActivity.class);
        startActivity(intent);
    }

    public void goToListViewApp() {
        Intent intent = new Intent( getApplicationContext(), ListViewActivity.class);
        startActivity(intent);
    }

    public void goToCustomListViewApp() {
        Intent intent = new Intent( getApplicationContext(), CustomListActivity.class);
        startActivity(intent);
    }

    public void goToPlanetApp() {
        Intent intent = new Intent( getApplicationContext(), PlanetActivity.class);
        startActivity(intent);
    }

}