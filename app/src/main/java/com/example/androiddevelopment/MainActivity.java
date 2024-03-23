package com.example.androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button greetingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingBtn = findViewById(R.id.greeting_btn);

      greetingBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              goToGreetingApp();
          }
      });

    }


    public void goToGreetingApp() {
        Intent intent = new Intent(this, GreetingActivity.class);
        startActivity(intent);
    }

}