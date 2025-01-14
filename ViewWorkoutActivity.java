package com.example.gymtrackerapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewWorkoutActivity extends AppCompatActivity {
    TextView workoutData;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);

        db = new DatabaseHelper(this);
        workoutData = findViewById(R.id.workoutData);

        String username = getIntent().getStringExtra("username");
        Cursor cursor = db.getWorkoutData(username);

        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()) {
            builder.append("Date: ").append(cursor.getString(1)).append("\n");
            builder.append("Pushups: ").append(cursor.getInt(2)).append("\n");
            builder.append("Benchpress: ").append(cursor.getInt(3)).append("\n");
            builder.append("Weight: ").append(cursor.getDouble(4)).append("\n\n");
        }

        workoutData.setText(builder.toString());
    }
}
