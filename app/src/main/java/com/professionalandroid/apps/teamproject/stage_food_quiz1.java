package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class stage_food_quiz1 extends AppCompatActivity {

    private Button mybtn;

    private Button btn_okay, btn_hint, btn_hint_okay, btn_watch,btn_goquiz;
    private EditText myET;
    private FrameLayout FL;
    private LinearLayout LL;
    private ConstraintLayout quizC, questC;
    private EditText e1,e2,e3,e4,e5,e6,e7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_quiz1);

        mybtn = findViewById(R.id.btn_start);

        btn_okay = findViewById(R.id.btn_okay);
        btn_hint = findViewById(R.id.btn_hint);

        btn_watch = findViewById(R.id.btn_watch_quiz);
        btn_hint_okay = findViewById(R.id.hin_okay);
        btn_goquiz = findViewById(R.id.go_quiz);

        myET = findViewById(R.id.myET);
        FL = findViewById(R.id.FL);
        LL = findViewById(R.id.LL);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);



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

        btn_watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                LL.setVisibility(View.VISIBLE);
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (e1.getText().toString().equals("1")&&e2.getText().toString().equals("2")
                                &&e3.getText().toString().equals("1")&&e4.getText().toString().equals("3")
                                &&e5.getText().toString().equals("2")&&e6.getText().toString().equals("3")
                                &&e7.getText().toString().equals("2"))
                        {
                            LL.setVisibility(View.INVISIBLE);
                            Toast.makeText(stage_food_quiz1.this, "정답", Toast.LENGTH_SHORT).show();
                            Toast.makeText(stage_food_quiz1.this, "다음퀴즈로 이동합니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(stage_food_quiz1.this, "오답", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btn_goquiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LL.setVisibility(View.INVISIBLE);
                    }
                });

            }
        });


        btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hint activity intent
                FL.setVisibility(View.VISIBLE);
                //Toast.makeText(stage_eg_quiz1_quest.this, "hint: ㅁㄴㅇㄹ", Toast.LENGTH_SHORT).show();
                Toast.makeText(stage_food_quiz1.this,"점수 -??점 " , Toast.LENGTH_LONG).show();
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