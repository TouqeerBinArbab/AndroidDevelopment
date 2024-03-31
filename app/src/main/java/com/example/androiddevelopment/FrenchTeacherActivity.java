package com.example.androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrenchTeacherActivity extends AppCompatActivity implements View.OnClickListener {
    Button blackBtn, greenBtn, purpleBtn, yellowBtn, redBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_teacher);

        blackBtn = findViewById(R.id.black_color);
        greenBtn = findViewById(R.id.green_color);
        purpleBtn = findViewById(R.id.purple_color);
        yellowBtn = findViewById(R.id.yellow_color);
        redBtn = findViewById(R.id.red_color);

        blackBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Find the button by ID and play the correct sound
        int clickedBtnId = v.getId();
        if (clickedBtnId == R.id.red_color) {
            playSound(R.raw.red);
            return;
        }
        if (clickedBtnId == R.id.black_color) {
            playSound(R.raw.black);
            return;
        }
        if (clickedBtnId == R.id.yellow_color) {
            playSound(R.raw.yellow);
            return;
        }
        if (clickedBtnId == R.id.green_color) {
            playSound(R.raw.green);
            return;
        }
        if (clickedBtnId == R.id.purple_color) {
            playSound(R.raw.purple);
        }
    }

    public void playSound(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), id);
        mediaPlayer.start();
    }
}