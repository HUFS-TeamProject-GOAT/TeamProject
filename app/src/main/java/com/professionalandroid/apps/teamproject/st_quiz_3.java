package com.professionalandroid.apps.teamproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class st_quiz_3 extends AppCompatActivity {
    private ConstraintLayout layout1, layout2;
    private int score,count;
    private TextView scoreTextView;
    String combinedUserAnswer;

    private static final String SHARED_PREFS_KEY = "quiz_score_4_3";
    private static final String SCORE_KEY = "score";
    private static final String COUNT_KEY = "count";
    private static final int SCORE_DEFAULT = 30;
    private static final int COUNT_DEFAULT = 0;
    private EditText answerEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_quiz3);

        scoreTextView = findViewById(R.id.scoreTextView);
        layout1 = findViewById(R.id.st_quiz3_frontLayout);
        layout2 = findViewById(R.id.st_quiz3_backLayout);
        answerEditText = findViewById(R.id.st_3_answer);
        Button submitButton = findViewById(R.id.st_3_submitButton);
        Button hintButton = findViewById(R.id.st_3_hint);
        Button laterButton = findViewById(R.id.st_3_nextTime);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        score = sharedPreferences.getInt(SCORE_KEY, SCORE_DEFAULT);
        count = sharedPreferences.getInt(COUNT_KEY, COUNT_DEFAULT);

        System.out.println("Saved Score: " + score);
        System.out.println("Saved Count: " + count);
        updateScoreText();

        layout1.setOnClickListener(view -> {
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.VISIBLE);
        });

        submitButton.setOnClickListener(v -> {
            String userAnswer = answerEditText.getText().toString();
            String correctAnswer = "1510";
            if (userAnswer.equals("1,5,10")) {
                String[] userAnswerArray = userAnswer.split(",");
                Arrays.sort(userAnswerArray);
                combinedUserAnswer = String.join("", userAnswerArray);
            } else {
                combinedUserAnswer = userAnswer;
            }
            boolean isCorrect = correctAnswer.equals(combinedUserAnswer);

            AlertDialog.Builder builder = new AlertDialog.Builder(st_quiz_3.this);
            builder.setIcon(R.mipmap.ic_launcher_round);
            builder.setPositiveButton("확인", null);
            AlertDialog dialog = builder.create();

            if (isCorrect) {
                dialog.setTitle("정답");
                dialog.setMessage("정답입니다!");
            } else {
                dialog.setTitle("실패");
                dialog.setMessage("틀렸습니다! 다시 한 번 생각해 보세요");
            }

            dialog.setOnShowListener(dialogInterface -> getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF"))));

            dialog.setOnDismissListener(dialogInterface -> {
                getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                if (isCorrect) {
                    saveScore(score);
                    saveCount(count);

                    finish();
                } else {
                    score -= 2;
                    if (score < 0) {
                        score = 0;
                    }


                    saveCount(count);
                    saveScore(score);
                    updateScoreText();
                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                }
            });

            dialog.show();
        });

        hintButton.setOnClickListener(v -> {
            if (count == 0) {
                score -= 1;
                if (score <= 0) {
                    score = 0;
                }
                count++;

                saveScore(score);
                saveCount(count);

            }

            AlertDialog.Builder builder = new AlertDialog.Builder(st_quiz_3.this);
            builder.setTitle("힌트");
            builder.setMessage(" 우선 모든 보석의 값을 더해 보자." +
                    "\n 모든 보석에 매겨진 값을 더하면 7800이 된다. " +
                    "\n 이를 3줄로 나누어야 하므로, 각 줄의 합계는 2600이 될 것이다." +
                    "\n 1000이상의 값을 지닌 3개의 보석은 각각 다른 줄에 속한다. 또한 각 줄의 끝에 배치되어 있다." +
                    "\n 이제 어느 방향으로 더해 나갈지만 생각하면 된다!");
            builder.setPositiveButton("확인", null);
            AlertDialog dialog = builder.create();

            dialog.setOnShowListener(dialogInterface -> getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF"))));

            dialog.setOnDismissListener(dialogInterface -> getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE)));

            dialog.show();
        });

        laterButton.setOnClickListener(v -> {
            saveScore(score);
            saveCount(count);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("score", score);
            resultIntent.putExtra("count", count);
            setResult(RESULT_CANCELED, resultIntent);

            Intent intent = new Intent(st_quiz_3.this, stHallActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_KEY, score);
        outState.putInt(COUNT_KEY, count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt(SCORE_KEY);
        count = savedInstanceState.getInt(COUNT_KEY);
        updateScoreText();
    }

    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SCORE_KEY, score);
        editor.apply();
    }

    private void saveCount(int count) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNT_KEY, count);
        editor.apply();
    }

    private void updateScoreText() {
        scoreTextView.setText(getString(R.string.score_format_3, score));
    }
}