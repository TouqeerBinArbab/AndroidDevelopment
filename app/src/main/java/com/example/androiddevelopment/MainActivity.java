package com.example.androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button luckyAppBtn, greetingAppBtn, counterAppBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        luckyAppBtn = findViewById(R.id.lucky_app);
        greetingAppBtn = findViewById(R.id.greeting_app);
        counterAppBtn = findViewById(R.id.counter_app);

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
}