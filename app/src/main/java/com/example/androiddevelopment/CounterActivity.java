package com.example.androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    TextView textView, counterText;
    Button increment, decrement, reset;

    int counter = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        textView = findViewById(R.id.welcome_text);
        counterText = findViewById(R.id.counter_text);
        increment = findViewById(R.id.increment_btn);
        decrement = findViewById(R.id.decrement_btn);
        reset = findViewById(R.id.reset_btn);

        increment.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                counterText.setText("" +increaseCounter());
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                counterText.setText("" +decreaseCounter());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                counterText.setText("" + reset());
            }
        });
    }

   public int increaseCounter(){
        return ++counter;
   }

    public int decreaseCounter(){
        if(counter > 0) {
            return --counter;
        }
        return counter;
    }

    public int reset(){
        counter = 0;
        return counter;
    }
}