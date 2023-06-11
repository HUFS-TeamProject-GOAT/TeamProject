package com.professionalandroid.apps.teamproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ctHallActivity extends AppCompatActivity {

    private int currentIndex = 0;
    private final int[] imageBackground = {R.drawable.cthall1, R.drawable.cthall2, R.drawable.cthall3, R.drawable.cthall4, R.drawable.cthall5};

    private ImageView ct_Background;
    protected void onCreate(Bundle savedInstacestate) {
        super.onCreate(savedInstacestate);
        setContentView(R.layout.cthall);

        ct_Background = findViewById(R.id.ct_Background);
        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_ctHall2btn = (ImageButton) findViewById(R.id.go_ctHall2btn);
        ImageButton go_ctHall3btn = (ImageButton) findViewById(R.id.go_ctHall3btn);
        ImageButton go_ctHall4btn = (ImageButton) findViewById(R.id.go_ctHall4btn);
        ImageButton go_ctHall5btn = (ImageButton) findViewById(R.id.go_ctHall5btn);
        ImageButton ctHall_last_btn = (ImageButton) findViewById(R.id.ctHall_last_btn);
        showNextBackground();


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
            }
        });
        go_ctHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),cthall_talk2Activity.class);
                startActivity(intent);

                go_ctHall3btn.setVisibility(View.VISIBLE);
                go_ctHall4btn.setVisibility(View.INVISIBLE);
                go_ctHall5btn.setVisibility(View.INVISIBLE);
                go_ctHall2btn.setVisibility(View.INVISIBLE);
                ctHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_ctHall3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),cthall_talk2Activity.class);
                startActivity(intent);


                go_ctHall3btn.setVisibility(View.INVISIBLE);
                go_ctHall4btn.setVisibility(View.INVISIBLE);
                go_ctHall5btn.setVisibility(View.VISIBLE);
                go_ctHall2btn.setVisibility(View.INVISIBLE);
                ctHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });

        go_ctHall4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();

                go_ctHall3btn.setVisibility(View.INVISIBLE);
                go_ctHall4btn.setVisibility(View.INVISIBLE);
                go_ctHall5btn.setVisibility(View.VISIBLE);
                go_ctHall2btn.setVisibility(View.INVISIBLE);
                ctHall_last_btn.setVisibility(View.INVISIBLE);


            }
        });
        go_ctHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();

                go_ctHall3btn.setVisibility(View.INVISIBLE);
                go_ctHall4btn.setVisibility(View.INVISIBLE);
                go_ctHall5btn.setVisibility(View.INVISIBLE);
                go_ctHall2btn.setVisibility(View.INVISIBLE);
                ctHall_last_btn.setVisibility(View.VISIBLE);


            }
        });
        ctHall_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();
                Intent intent1 =new Intent(getApplicationContext(),cthall_talk2Activity.class);
                startActivity(intent1);
            }
        });

    }

    private void showNextBackground() {
        if (currentIndex == 0) {
            ct_Background.setImageResource(imageBackground[0]);
        }
        else if (currentIndex == 1) {
            ct_Background.setImageResource(imageBackground[1]);
        }
        else if (currentIndex == 2) {
            ct_Background.setImageResource(imageBackground[3]);
        }
        else if (currentIndex == 3) {
            ct_Background.setImageResource(imageBackground[4]);
        }
    }
}