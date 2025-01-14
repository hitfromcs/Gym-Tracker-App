package com.example.gymtrackerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ExerciseDetailFragment extends Fragment {

    private static final String EXERCISE_NAME = "exercise_name";


    public static ExerciseDetailFragment newInstance(String exerciseName) {
        ExerciseDetailFragment fragment = new ExerciseDetailFragment();
        Bundle args = new Bundle();
        args.putString(EXERCISE_NAME, exerciseName);
        fragment.setArguments(args);
        return fragment;
    }

    private String getExerciseDescription(String exerciseName) {
        switch (exerciseName) {
            case "Push-Ups":
                return "Push-ups help to build upper body strength. Start in a plank position with your hands slightly wider than shoulder-width apart. Lower your body toward the ground and then push back up.";
            case "Bench Press":
                return "The bench press targets your chest, shoulders, and triceps. Lie on a bench and press the barbell up and down in a controlled motion.";
            case "Squats":
                return "Stand with feet shoulder-width apart. Lower your body by bending your knees and hips, ensuring your knees do not go past your toes.";
            case "Deadlifts":
                return "Stand with feet hip-width apart, grip the barbell, and lift it by extending your hips and knees. Keep your back flat.";
            case "Lunges":
                return "Step forward with one leg, lowering your hips until both knees are bent at about 90 degrees. Alternate legs.";
            case "Planks":
                return "Maintain a straight line from your head to your heels while balancing on your forearms and toes. Keep your core tight.";
            case "Overhead Press":
                return "Grip the barbell at shoulder height and press it overhead. Keep your core tight and avoid arching your back.";
            case "Pull-Ups":
                return "Hang from a pull-up bar and pull your body up until your chin is above the bar. Lower yourself back down with control.";
            case "Bicep Curls":
                return "Hold dumbbells with your arms fully extended, curl the weights towards your shoulders, then lower them slowly.";
            case "Tricep Dips":
                return "Sit on a bench and place your hands behind you. Lower your body by bending your elbows, then push yourself back up.";
            default:
                return "No description available.";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_detail, container, false);

        String exerciseName = getArguments().getString(EXERCISE_NAME);
        TextView exerciseTextView = rootView.findViewById(R.id.exerciseDescription);
        exerciseTextView.setText(getExerciseDescription(exerciseName));

        return rootView;
    }


}
