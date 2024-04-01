package com.example.androiddevelopment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<App> appsArrayList;
    private static AppCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. AdapterView
        listView = findViewById(R.id.apps_list);

        // 2- Data Source: ArrayList<Planet>
        appsArrayList = new ArrayList<>();

        App app1 = new App("Greeting App");
        App app2 = new App("Lucky App");
        App app3 = new App("Counter App");
        App app4 = new App("French App");
        App app5 = new App("List View App");
        App app6 = new App("Custom List View App");
        App app7 = new App("Planet App");

        appsArrayList.add(app1);
        appsArrayList.add(app2);
        appsArrayList.add(app3);
        appsArrayList.add(app4);
        appsArrayList.add(app5);
        appsArrayList.add(app6);
        appsArrayList.add(app7);

        // Adapter:
        adapter = new AppCustomAdapter(appsArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                String item = parent.getItemAtPosition(position)+"";

                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, GreetingActivity.class);
                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, LuckyActivity.class);
                        break;

                    case 2:
                        intent = new Intent(MainActivity.this, CounterActivity.class);
                        break;

                    case 3:
                        intent = new Intent(MainActivity.this, FrenchTeacherActivity.class);
                        break;

                    case 4:
                        intent = new Intent(MainActivity.this, ListViewActivity.class);
                        break;

                    case 5:
                        intent = new Intent(MainActivity.this, CustomListActivity.class);
                        break;

                    case 6:
                        intent = new Intent(MainActivity.this, PlanetActivity.class);
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "This is " + item, Toast.LENGTH_SHORT).show();
                }
                if(intent != null) {
                    startActivity(intent);
                }
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
}