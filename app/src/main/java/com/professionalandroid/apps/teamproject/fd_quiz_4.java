package com.professionalandroid.apps.teamproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fd_quiz_4 extends AppCompatActivity {
    private ConstraintLayout layout1, layout2;
    private int score,count;
    private TextView scoreTextView;

    private static final String SHARED_PREFS_KEY = "quiz_score_3_4";
    private static final String SCORE_KEY = "score";
    private static final String COUNT_KEY = "count";
    private static final int SCORE_DEFAULT = 10;
    private static final int COUNT_DEFAULT = 0;
    private EditText answerEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fd_quiz4);

        scoreTextView = findViewById(R.id.scoreTextView);
        layout1 = findViewById(R.id.fd_quiz4_frontLayout);
        layout2 = findViewById(R.id.fd_quiz4_backLayout);
        answerEditText = findViewById(R.id.fd_4_answer);
        Button submitButton = findViewById(R.id.fd_4_submitButton);
        Button hintButton = findViewById(R.id.fd_4_hint);
        Button laterButton = findViewById(R.id.fd_4_nextTime);

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
            String correctAnswer = "15";
            boolean isCorrect = userAnswer.equals(correctAnswer);

            AlertDialog.Builder builder = new AlertDialog.Builder(fd_quiz_4.this);
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

                    Intent intent = new Intent();
                    intent.putExtra("quizFinished",true);
                    setResult(Activity.RESULT_OK,intent);
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

                Intent resultIntent = new Intent();
                resultIntent.putExtra("score", score);
                resultIntent.putExtra("count", count);
                setResult(RESULT_CANCELED, resultIntent);
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(fd_quiz_4.this);
            builder.setTitle("힌트");
            builder.setMessage("가장 작은 팬케이크를 붉은 접시에 올려놓고, 중간 크기의 팬케이크를 가운데 접시에 올려놓아 보자. 그리고 가장 작은 팬케이크를 중간 크기의 팬케이크에 올려놓으면, 가장 큰 팬케이크를 붉은 접시에 올려놓을 수 있다.");
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

            Intent intent = new Intent(fd_quiz_4.this, stHallActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_KEY, score);
        outState.putInt("count", count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt(SCORE_KEY);
        count = savedInstanceState.getInt("count");
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
        scoreTextView.setText(getString(R.string.score_format_3_4, score));
    }
}