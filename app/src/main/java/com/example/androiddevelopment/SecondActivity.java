package com.example.androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeText;
    TextView luckyNumberText;
    Button share_btn;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeText = findViewById(R.id.number_heading);
        luckyNumberText = findViewById(R.id.lucky_number);
        share_btn = findViewById(R.id.share_btn);


        Intent i = getIntent();

        String userName = i.getStringExtra("name");

        int random_num = generateRandomNumber();
        luckyNumberText.setText(String.valueOf(random_num));

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random_num);
            }
        });
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int upper_limit = 1000;
        return random.nextInt(upper_limit);
    }

    public void shareData(String username, int randomNum){
        // Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        // Additional info
        i.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: " + randomNum);
        startActivity(Intent.createChooser(i, "Choose your platform"));
    }
}