package com.example.androiddevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. AdapterView
        listView = findViewById(R.id.list_view);

        // 2. Data Source
        String[]  countries = { "USA", "Germany", " Saudi Arabia", "France"};

        // Adapter: 'acts as a bridge between the 'data source' and
        //           AdapterView'

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                String item = parent.getItemAtPosition(position)+"";

                switch (position) {
                    case 0:
                    intent = new Intent(ListViewActivity.this, GreetingActivity.class);
                    break;

                    default:
                        Toast.makeText(ListViewActivity.this, "This is " + item, Toast.LENGTH_SHORT).show();
                }
                if(intent != null) {
                    startActivity(intent);
                }
                          }
        });


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent i = new Intent(getActivity(), DiscussAddValu.class);
//                startActivity(i);
//            }
//        });


    }
}