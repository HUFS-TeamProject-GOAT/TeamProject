package com.professionalandroid.apps.teamproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class stHallActivity extends AppCompatActivity {

    //이미지를 바꿔줄 변수, 값을 바꿔가며 배열의 인덱스값을 참조해서 이미지를 변화시킴
    private int currentIndex = 0;
    //화면에 보여질 이미지들을 담은 배열
    private final int[] imageBackground = {R.drawable.sthall1, R.drawable.sthall2, R.drawable.sthall3, R.drawable.sthall4, R.drawable.sthall5};

    private ImageView st_Background;
    public MediaPlayer clickPlay;

    protected void onCreate(Bundle savedInstacestate) {
        super.onCreate(savedInstacestate);
        setContentView(R.layout.sthall);
        clickPlay = MediaPlayer.create(this, R.raw.click);

        st_Background = findViewById(R.id.st_Background);
        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_stHall2btn = (ImageButton) findViewById(R.id.go_stHall2btn);
        ImageButton go_stHall3btn = (ImageButton) findViewById(R.id.go_stHall3btn);
        ImageButton go_stHall4btn = (ImageButton) findViewById(R.id.go_stHall4btn);
        ImageButton go_stHall5btn = (ImageButton) findViewById(R.id.go_stHall5btn);
        ImageButton stHall_last_btn = (ImageButton) findViewById(R.id.stHall_last_btn);
        showNextBackground();


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        go_stHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),sthall_talk1Activity.class);
                startActivity(intent);


                go_stHall3btn.setVisibility(View.VISIBLE);
                go_stHall4btn.setVisibility(View.INVISIBLE);
                go_stHall5btn.setVisibility(View.INVISIBLE);
                go_stHall2btn.setVisibility(View.INVISIBLE);
                stHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_stHall3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),sthall_talk2Activity.class);
                startActivity(intent);


                go_stHall3btn.setVisibility(View.INVISIBLE);
                go_stHall4btn.setVisibility(View.VISIBLE);
                go_stHall5btn.setVisibility(View.INVISIBLE);
                go_stHall2btn.setVisibility(View.INVISIBLE);
                stHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_stHall4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_stHall3btn.setVisibility(View.INVISIBLE);
                go_stHall4btn.setVisibility(View.INVISIBLE);
                go_stHall5btn.setVisibility(View.VISIBLE);
                go_stHall2btn.setVisibility(View.INVISIBLE);
                stHall_last_btn.setVisibility(View.INVISIBLE);


                Intent intent =new Intent(getApplicationContext(),sthall_talk3Activity.class);
                startActivity(intent);
            }
        });

        go_stHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_stHall3btn.setVisibility(View.INVISIBLE);
                go_stHall4btn.setVisibility(View.INVISIBLE);
                go_stHall5btn.setVisibility(View.INVISIBLE);
                go_stHall2btn.setVisibility(View.INVISIBLE);
                stHall_last_btn.setVisibility(View.VISIBLE);


            }
        });
        stHall_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();
                Intent intent1 =new Intent(getApplicationContext(),sthall_talk4Activity.class);
                startActivity(intent1);
                finish();
            }
        });

    }

    private void showNextBackground() {
        if (currentIndex == 0) {
            st_Background.setImageResource(imageBackground[0]);
        }
        else if (currentIndex == 1) {
            st_Background.setImageResource(imageBackground[1]);
        }
        else if (currentIndex == 2) {
            st_Background.setImageResource(imageBackground[2]);
        }
        else if (currentIndex == 3) {
            st_Background.setImageResource(imageBackground[3]);
        }
        else if (currentIndex == 4) {
            st_Background.setImageResource(imageBackground[4]);
        }
    }
}