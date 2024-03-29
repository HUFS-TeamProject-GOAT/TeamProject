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

public class eg_quiz_1 extends AppCompatActivity {
    private ConstraintLayout layout1, layout2;
    private int score,count;
    private TextView scoreTextView;

    private static final String SHARED_PREFS_KEY = "quiz_score";
    private static final String SCORE_KEY = "score"+4; //점수저장 키 값
    private static final String COUNT_KEY = "count"+4; // 힌트 사용유무의 저장
    private static final int SCORE_DEFAULT = 15; // 얻을수 있는 최대 점수 값
    private static final int COUNT_DEFAULT = 0; // 처음 입장시 힌트를 본적이 없기에 0으로 설정
    public MediaPlayer clickPlay; //클릭시 사운드 나오게 구현

    // 점수 저장 객체와 의 key 값 지정
    // SCORE_KEY: score 점수 저장하는 preference 객체
    // COUNT_KEY: hint 사용 여부를 확인하는 preference 객체
    // 이 문제의 score 총점 20점
    private EditText answerEditText; // 정답을 입력받을 곳


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg_quiz1);
        clickPlay = MediaPlayer.create(this, R.raw.click);

        scoreTextView = findViewById(R.id.scoreTextView);
        layout1 = findViewById(R.id.eg_quiz1_frontLayout);  // 퀴즈 레이아웃의 초기화면 최대 받을 수 있는 값과 현재 받을 수 있는 값이 나옴
        layout2 = findViewById(R.id.eg_quiz1_backLayout); // 퀴즈 레이아웃의 두번째 화면으로 퀴즈 내용과 각종 버튼이 구현됨
        answerEditText = findViewById(R.id.eg_1_answer);
        Button submitButton = findViewById(R.id.eg_1_submitButton);
        Button hintButton = findViewById(R.id.eg_1_hint);
        Button laterButton = findViewById(R.id.eg_1_nextTime); //나중에 풀기

        //공유프리퍼런스를 이용한 점수값과 힌트의 저장
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        score = sharedPreferences.getInt(SCORE_KEY, SCORE_DEFAULT);
        count = sharedPreferences.getInt(COUNT_KEY, COUNT_DEFAULT);


        updateScoreText(); // 스코어 값의 업데이트

        layout1.setOnClickListener(view -> {
            clickPlay.start();
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.VISIBLE);
        });
        // layout1을 눌렀을 때, 문제화면을 보여주는 코드.


        //제출버튼
        submitButton.setOnClickListener(v -> {
            clickPlay.start();
            String userAnswer = answerEditText.getText().toString(); //  User가 EditText에 입력한 값 로드.
            String correctAnswer = "3"; // 문제 정답.
            boolean isCorrect = userAnswer.equals(correctAnswer); // 정답여부 판별.


            AlertDialog.Builder builder = new AlertDialog.Builder(eg_quiz_1.this);
            builder.setIcon(R.mipmap.ic_launcher_round);
            builder.setPositiveButton(getString(R.string.check), null);  // // AlertDialog에 "확인" 버튼을 추가합니다.
            AlertDialog dialog = builder.create();

            if (isCorrect) {
                dialog.setTitle(getString(R.string.correct));
                dialog.setMessage(getText(R.string.right));
            } else {
                dialog.setTitle(getString(R.string.notcorrect));
                dialog.setMessage(getText(R.string.wrong));
            }


            dialog.setOnShowListener(dialogInterface ->
                    getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF"))));

            dialog.setOnDismissListener(dialogInterface -> {
                getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                if (isCorrect) {
                    saveScore(score);
                    saveCount(count);

                    Intent intent = new Intent();
                    intent.putExtra("quizFinished",true);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                else {
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


        // hint button
        hintButton.setOnClickListener(v -> {
            clickPlay.start();
            if (count == 0) {
                score -= 1;

                if (score <= 0) {
                    score = 0;
                } // score값
                count++;

                saveScore(score);
                saveCount(count);

                Intent resultIntent = new Intent();
                resultIntent.putExtra("score", score);
                resultIntent.putExtra("count", count);
                setResult(RESULT_CANCELED, resultIntent);
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(eg_quiz_1.this);
            builder.setTitle(getString(R.string.hint));
            builder.setMessage(getString(R.string.eg_quiz_2_1_hint));
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

            Intent intent = new Intent(eg_quiz_1.this, homeActivity.class);
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
        scoreTextView.setText(getString(R.string.score_format_2_1, score));
    }
}