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
import android.media.MediaPlayer;

public class Tutorial extends AppCompatActivity {
    private ConstraintLayout layout1, layout2;
    private int score,count;
    private TextView scoreTextView;

    private static final String SHARED_PREFS_KEY = "quiz_score";
    private static final String SCORE_KEY = "score"+0; //점수저장 키 값
    private static final String COUNT_KEY = "count"+0; // 힌트 사용유무의 저장
    private static final int SCORE_DEFAULT = 10; // 얻을수 있는 최대 점수 값
    private static final int COUNT_DEFAULT = 0; // 처음 입장시 힌트를 본적이 없기에 0으로 설정
    private EditText answerEditText; // 정답을 입력받을 곳

    public MediaPlayer clickPlay; //클릭시 사운드 나오게 구현


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_quiz1); //ct_quiz1의 레이아웃을 사용
        clickPlay = MediaPlayer.create(this, R.raw.click);

        scoreTextView = findViewById(R.id.scoreTextView);
        layout1 = findViewById(R.id.ct_quiz1_frontLayout);  // 퀴즈 레이아웃의 초기화면 최대 받을 수 있는 값과 현재 받을 수 있는 값이 나옴
        layout2 = findViewById(R.id.ct_quiz1_backLayout); // 퀴즈 레이아웃의 두번째 화면으로 퀴즈 내용과 각종 버튼이 구현됨

        Button submitButton = findViewById(R.id.ct_1_submitButton);
        Button hintButton = findViewById(R.id.ct_1_hint);
        Button laterButton = findViewById(R.id.ct_1_nextTime); //나중에 풀기
        answerEditText = findViewById(R.id.ct_1_answer);

        //공유프리퍼런스를 이용한 점수값과 힌트의 저장
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        score = sharedPreferences.getInt(SCORE_KEY, SCORE_DEFAULT);
        count = sharedPreferences.getInt(COUNT_KEY, COUNT_DEFAULT);


        updateScoreText();// 스코어 값 업데이트

        layout1.setOnClickListener(view -> {
            clickPlay.start();
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.VISIBLE);
        });

        submitButton.setOnClickListener(v -> {
            clickPlay.start();
//            String userAnswer = answerEditText.getText().toString();
//            String correctAnswer = "1";
            boolean isCorrect = true; // 문제의 정답 유무를 위한 bool타입의 변수

            AlertDialog.Builder builder = new AlertDialog.Builder(Tutorial.this);
            builder.setIcon(R.mipmap.ic_launcher_round);
            builder.setPositiveButton(getString(R.string.check), null);
            AlertDialog dialog = builder.create();

            if (isCorrect) {
                dialog.setTitle(getString(R.string.correct));
                dialog.setMessage(getText(R.string.right));
            } else {
                dialog.setTitle(getString(R.string.notcorrect));
                dialog.setMessage(getText(R.string.wrong));
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
            clickPlay.start();
            if (count == 0) {
                score -= 0;
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

            AlertDialog.Builder builder = new AlertDialog.Builder(Tutorial.this);
            builder.setTitle(getString(R.string.hint));
            builder.setMessage(getString(R.string.ct_quiz_1_1_hint));
            builder.setPositiveButton("확인", null);
            AlertDialog dialog = builder.create();

            dialog.setOnShowListener(dialogInterface -> getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF"))));

            dialog.setOnDismissListener(dialogInterface -> getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE)));

            dialog.show();
        });

        laterButton.setOnClickListener(v -> {
            clickPlay.start();
            saveScore(score);
            saveCount(count);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("score", score);
            resultIntent.putExtra("count", count);
            setResult(RESULT_CANCELED, resultIntent);

            Intent intent = new Intent(Tutorial.this, homeActivity.class);
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

    private void saveScore(int score) { // 공유 프리퍼런스에 저장
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SCORE_KEY, score);
        editor.apply();
    }

    private void saveCount(int count) { // 공유 프리퍼런스에 저장
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNT_KEY, count);
        editor.apply();
    }

    private void updateScoreText() {
        scoreTextView.setText(getString(R.string.score_format_1_1, score));
    }

}