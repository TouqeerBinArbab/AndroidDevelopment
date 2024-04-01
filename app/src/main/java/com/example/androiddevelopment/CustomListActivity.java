package com.example.androiddevelopment;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomListActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list);
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

        MyCustomAdapter adapter = new MyCustomAdapter(this,  countries);
        listView.setAdapter(adapter);

    }
}