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

import java.util.Arrays;

public class st_quiz_3_1 extends AppCompatActivity { // 문제 오류
    EditText answerEditText;
    Button submitButton, hintButton, laterButton;
    private int score;
    private int count = 0;
    private static final String SHARED_PREFS_KEY = "quiz_score_4_3";
    private static final String SCORE_KEY = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_quiz31);
        answerEditText = findViewById(R.id.st_3_answer);
        submitButton = findViewById(R.id.st_3_submitButton);
        hintButton = findViewById(R.id.st_3_hint);
        laterButton = findViewById(R.id.st_3_nextTime);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 0);

        score = getIntent().getIntExtra("score", 30);

        EditText st2AnswerEditText = findViewById(R.id.st_3_answer); // 엔터 입력 시 키보드를 내린다.
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
                String correctAnswer = "1510";
                String combinedUserAnswer;
                if (userAnswer.equals("1,5,10")) {
                    String[] userAnswerArray = userAnswer.split(",");
                    Arrays.sort(userAnswerArray);
                    combinedUserAnswer = String.join("", userAnswerArray);
                } else {
                    combinedUserAnswer = userAnswer;
                }
                boolean isCorrect = combinedUserAnswer.equals(correctAnswer);

                AlertDialog.Builder builder = new AlertDialog.Builder(st_quiz_3_1.this);
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
                        Intent intent = new Intent(st_quiz_3_1.this, ctHallActivity.class);
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
                if(count == 0) {
                    score -= 1;
                    if (score <= 0) {
                        score = 0;
                    }
                    count++;

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("count", count);
                    editor.apply();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(st_quiz_3_1.this);
                builder.setTitle("힌트");
                builder.setMessage(" 우선 모든 보석의 값을 더해 보자." +
                        "\n 모든 보석에 매겨진 값을 더하면 7800이 된다. " +
                        "\n 이를 3줄로 나누어야 하므로, 각 줄의 합계는 2600이 될 것이다." +
                        "\n 1000이상의 값을 지닌 3개의 보석은 각각 다른 줄에 속한다. 또한 각 줄의 끝에 배치되어 있다." +
                        "\n 이제 어느 방향으로 더해 나갈지만 생각하면 된다!");
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

                Intent intent = new Intent(st_quiz_3_1.this, ctHallActivity.class);
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
        editor.putInt("count", count); // count 값을 저장
        editor.apply();
    }
}
