package com.example.gymtrackerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutEntryActivity extends AppCompatActivity {
    EditText pushups, benchpress, weight, date;
    Button saveButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_entry);

        db = new DatabaseHelper(this);

        pushups = findViewById(R.id.pushups);
        benchpress = findViewById(R.id.benchpress);
        weight = findViewById(R.id.weight);
        date = findViewById(R.id.date);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(view -> {
            String username = getIntent().getStringExtra("username");
            String workoutDate = date.getText().toString();
            int pushupCount = Integer.parseInt(pushups.getText().toString());
            int benchpressCount = Integer.parseInt(benchpress.getText().toString());
            double currentWeight = Double.parseDouble(weight.getText().toString());

            if (db.saveWorkout(username, workoutDate, pushupCount, benchpressCount, currentWeight)) {
                Toast.makeText(WorkoutEntryActivity.this, "Workout Saved!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(WorkoutEntryActivity.this, "Error Saving Workout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
