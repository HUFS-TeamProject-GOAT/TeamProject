package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class egHallActivity extends AppCompatActivity {
    private int currentIndex = 0;
    private final int[] imageBackground = {R.drawable.eghall1, R.drawable.eghall2, R.drawable.eghall3, R.drawable.eghall4, R.drawable.eghall5};

    private ImageView eg_Background;
    public MediaPlayer clickPlay;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.eghall);
        clickPlay = MediaPlayer.create(this, R.raw.click);

        eg_Background = findViewById(R.id.eg_Background);
        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_egHall2btn = (ImageButton) findViewById(R.id.go_egHall2btn);
        ImageButton go_egHall3btn = (ImageButton) findViewById(R.id.go_egHall3btn);
        ImageButton go_egHall4btn = (ImageButton) findViewById(R.id.go_egHall4btn);
        ImageButton go_egHall5btn = (ImageButton) findViewById(R.id.go_egHall5btn);
        ImageButton egHall_last_btn = (ImageButton) findViewById(R.id.egHall_last_btn);
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
        go_egHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),eghall_talk1Activity.class);
                startActivity(intent);


                go_egHall3btn.setVisibility(View.VISIBLE);
                go_egHall4btn.setVisibility(View.INVISIBLE);
                go_egHall5btn.setVisibility(View.INVISIBLE);
                go_egHall2btn.setVisibility(View.INVISIBLE);
                egHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_egHall3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_egHall3btn.setVisibility(View.INVISIBLE);
                go_egHall4btn.setVisibility(View.VISIBLE);
                go_egHall5btn.setVisibility(View.INVISIBLE);
                go_egHall2btn.setVisibility(View.INVISIBLE);
                egHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_egHall4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),eghall_talk2Activity.class);
                startActivity(intent);

                go_egHall3btn.setVisibility(View.INVISIBLE);
                go_egHall4btn.setVisibility(View.INVISIBLE);
                go_egHall5btn.setVisibility(View.VISIBLE);
                go_egHall2btn.setVisibility(View.INVISIBLE);
                egHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_egHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),eghall_talk3Activity.class);
                startActivity(intent);

                go_egHall3btn.setVisibility(View.INVISIBLE);
                go_egHall4btn.setVisibility(View.INVISIBLE);
                go_egHall5btn.setVisibility(View.INVISIBLE);
                go_egHall2btn.setVisibility(View.INVISIBLE);
                egHall_last_btn.setVisibility(View.VISIBLE);

            }
        });
        egHall_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),eghall_talk4Activity.class);
                startActivity(intent);
               finish();

            }
        });
    }
    private void showNextBackground() {
        if (currentIndex == 0) {
            eg_Background.setImageResource(imageBackground[0]);
        }
        else if (currentIndex == 1) {
            eg_Background.setImageResource(imageBackground[1]);
        }
        else if (currentIndex == 2) {
            eg_Background.setImageResource(imageBackground[2]);
        }
        else if (currentIndex == 3) {
            eg_Background.setImageResource(imageBackground[3]);
        }else if (currentIndex == 4) {
            eg_Background.setImageResource(imageBackground[4]);
        }
    }
}
