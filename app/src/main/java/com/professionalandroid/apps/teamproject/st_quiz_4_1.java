package com.professionalandroid.apps.teamproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class st_quiz_4_1 extends AppCompatActivity {
    EditText answerEditText;
    Button submitButton, hintButton, laterButton;
    private int score;
    private int count = 0;
    private static final String SHARED_PREFS_KEY = "quiz_score_4_4";
    private static final String SCORE_KEY = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_quiz41);
        answerEditText = findViewById(R.id.st_4_answer);
        submitButton = findViewById(R.id.st_4_submitButton);
        hintButton = findViewById(R.id.st_4_hint);
        laterButton = findViewById(R.id.st_4_nextTime);

        score = getIntent().getIntExtra("score", 50);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 0);

        EditText st2AnswerEditText = findViewById(R.id.st_4_answer);
        st2AnswerEditText.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                return true;
            }
            return false;
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = answerEditText.getText().toString();
                String correctAnswer = "0154";
                boolean isCorrect = userAnswer.equals(correctAnswer);

                AlertDialog.Builder builder = new AlertDialog.Builder(st_quiz_4_1.this);
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

                dialog.setOnShowListener(dialogInterface -> {
                    getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF")));
                });

                dialog.setOnDismissListener(dialogInterface -> {
                    getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                    if (isCorrect) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("score", score);
                        setResult(RESULT_OK, resultIntent);
                        Intent intent = new Intent(st_quiz_4_1.this, ctHallActivity.class);
                        startActivity(intent);
                    } else {
                        score -= 2;
                        if (score < 0) {
                            score = 0;
                        }
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("score", score);
                        setResult(RESULT_OK, new Intent().putExtra("score", score));
                    }
                    finish();
                });

                dialog.show();
            }
        });

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
                    score -= 1;
                    if (score <= 0) {
                        score = 0;
                    }
                    count++;

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("count", count);
                    editor.apply();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(st_quiz_4_1.this);
                builder.setTitle("힌트");
                builder.setMessage(" 숫자가 들어갈 자리는 제쳐 두고 어떤 숫자가 사용될지부터 먼저 생각해보자." +
                        "\n 첫 번째 줄에서 알 수 있는 사실은 4개의 숫자가 4150이라는 사실." +
                        "\n 그 중 위치까지 맞는 숫자는 2개, 잘 생각해 보자.");
                builder.setPositiveButton("확인", null);
                AlertDialog dialog = builder.create();

                dialog.setOnShowListener(dialogInterface -> {
                    getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF")));
                });

                dialog.setOnDismissListener(dialogInterface -> {
                    getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                });

                dialog.show();
            }
        });

        laterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("score", score);
                setResult(RESULT_OK, resultIntent);

                Intent intent = new Intent(st_quiz_4_1.this, ctHallActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SCORE_KEY, score);
        editor.putInt("count", count);
        editor.apply();
    }
}