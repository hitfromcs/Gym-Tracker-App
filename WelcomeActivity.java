package com.example.gymtrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    Button enterDataButton, viewDataButton, viewExercisesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        enterDataButton = findViewById(R.id.enterDataButton);
        viewDataButton = findViewById(R.id.viewDataButton);
        viewExercisesButton = findViewById(R.id.viewExercisesButton);

        enterDataButton.setOnClickListener(view -> {
            Intent intent = new Intent(WelcomeActivity.this, WorkoutEntryActivity.class);
            intent.putExtra("username", getIntent().getStringExtra("username"));
            startActivity(intent);
        });

        viewDataButton.setOnClickListener(view -> {
            Intent intent = new Intent(WelcomeActivity.this, ViewWorkoutActivity.class);
            intent.putExtra("username", getIntent().getStringExtra("username"));
            startActivity(intent);

        });

        viewExercisesButton.setOnClickListener(view -> {
            Intent intent = new Intent(WelcomeActivity.this, WorkoutExercisesActivity.class);
            startActivity(intent);
        });


    }
}
