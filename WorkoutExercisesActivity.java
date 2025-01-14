package com.example.gymtrackerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_exercises);


        Button pushupsButton = findViewById(R.id.pushupsButton);
        Button benchpressButton = findViewById(R.id.benchpressButton);
        Button squatsButton = findViewById(R.id.squatsButton);
        Button deadliftsButton = findViewById(R.id.deadliftsButton);
        Button lungesButton = findViewById(R.id.lungesButton);
        Button planksButton = findViewById(R.id.planksButton);
        Button overheadPressButton = findViewById(R.id.overheadPressButton);
        Button pullupsButton = findViewById(R.id.pullupsButton);
        Button bicepCurlsButton = findViewById(R.id.bicepCurlsButton);
        Button tricepDipsButton = findViewById(R.id.tricepDipsButton);


        pushupsButton.setOnClickListener(view -> openExerciseDetailFragment("Push-Ups"));
        benchpressButton.setOnClickListener(view -> openExerciseDetailFragment("Bench Press"));
        squatsButton.setOnClickListener(view -> openExerciseDetailFragment("Squats"));
        deadliftsButton.setOnClickListener(view -> openExerciseDetailFragment("Deadlifts"));
        lungesButton.setOnClickListener(view -> openExerciseDetailFragment("Lunges"));
        planksButton.setOnClickListener(view -> openExerciseDetailFragment("Planks"));
        overheadPressButton.setOnClickListener(view -> openExerciseDetailFragment("Overhead Press"));
        pullupsButton.setOnClickListener(view -> openExerciseDetailFragment("Pull-Ups"));
        bicepCurlsButton.setOnClickListener(view -> openExerciseDetailFragment("Bicep Curls"));
        tricepDipsButton.setOnClickListener(view -> openExerciseDetailFragment("Tricep Dips"));
    }

    private void openExerciseDetailFragment(String exerciseName) {
        ExerciseDetailFragment fragment = ExerciseDetailFragment.newInstance(exerciseName);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}


