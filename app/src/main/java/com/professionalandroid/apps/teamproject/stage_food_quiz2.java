package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class stage_food_quiz2 extends AppCompatActivity {

    private Button mybtn;

    private Button btn_okay, btn_hint, btn_hint_okay;
    private EditText myET;
    private FrameLayout FL;
    private ConstraintLayout quizC, questC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_quiz2);

        mybtn = findViewById(R.id.btn_start);

        btn_okay = findViewById(R.id.btn_okay);
        btn_hint = findViewById(R.id.btn_hint);
        btn_hint_okay = findViewById(R.id.hin_okay);
        myET = findViewById(R.id.myET);
        FL = findViewById(R.id.FL);

        quizC = findViewById(R.id.quizC);
        questC  = findViewById(R.id.questC);


    }

    @Override
    protected void onStart() {
        super.onStart();

        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizC.setVisibility(View.INVISIBLE);
                questC.setVisibility(View.VISIBLE);
            }
        });

        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myET.getText().toString().equals("10시선")){
                    Toast.makeText(stage_food_quiz2.this, "정답", Toast.LENGTH_SHORT).show();
                    Toast.makeText(stage_food_quiz2.this, "다음퀴즈로 이동합니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(stage_food_quiz2.this, "오답", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hint activity intent
                FL.setVisibility(View.VISIBLE);
                //Toast.makeText(stage_eg_quiz1_quest.this, "hint: ㅁㄴㅇㄹ", Toast.LENGTH_SHORT).show();
                Toast.makeText(stage_food_quiz2.this,"점수 -??점 " , Toast.LENGTH_LONG).show();
            }
        });
        btn_hint_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FL.setVisibility(View.INVISIBLE);
            }
        });
    }
}