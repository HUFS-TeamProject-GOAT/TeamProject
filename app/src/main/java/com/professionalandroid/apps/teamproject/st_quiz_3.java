package com.professionalandroid.apps.teamproject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class st_quiz_3 extends AppCompatActivity {
    private ConstraintLayout layout;
    private int score = 30;
    private TextView scoreTextView;
    private static final int REQUEST_CODE_QUIZ_3_1 = 1;
    private ActivityResultLauncher<Intent> quiz3Launcher;
    private static final String KEY_SCORE = "score";
    private static final String SHARED_PREFS_KEY = "quiz_score_4_3";
    private static final String SCORE_KEY = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        quiz3Launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                    int updatedScore = data.getIntExtra("score", score);
                    score = updatedScore;
                    updateScoreText();
                }
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_quiz3);
        scoreTextView = findViewById(R.id.scoreTextView);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        score = sharedPreferences.getInt(SCORE_KEY, 30);
        updateScoreText();

        layout = findViewById(R.id.st_quiz3_layout);
        layout.setOnClickListener(view -> {
            Intent intent = new Intent(st_quiz_3.this, st_quiz_3_1.class);
            intent.putExtra("score", score);
            quiz3Launcher.launch(intent);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ_3_1 && resultCode == RESULT_OK && data != null) {
            int updatedScore = data.getIntExtra("score", score);
            score = updatedScore;
            updateScoreText();

            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(SCORE_KEY, score);
            editor.apply();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SCORE_KEY, score);
        editor.apply();
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        score = sharedPreferences.getInt(SCORE_KEY, 30);
    }
    private void updateScoreText() {
        scoreTextView.setText(score + "/30");
    }
}
