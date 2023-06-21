package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class ctHallActivity extends AppCompatActivity {

    private int currentIndex = 0;
    private final int[] imageBackground = {R.drawable.cthall1, R.drawable.cthall2, R.drawable.cthall3, R.drawable.cthall4, R.drawable.cthall5};

    private ImageView ct_Background;
    public MediaPlayer clickPlay;

    protected void onCreate(Bundle savedInstacestate) {
        clickPlay = MediaPlayer.create(this, R.raw.click);
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
            public void onClick(View v) {
                clickPlay.start();
                Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        go_ctHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_ctHall3btn.setVisibility(View.VISIBLE);
                go_ctHall4btn.setVisibility(View.GONE);
                go_ctHall5btn.setVisibility(View.GONE);
                go_ctHall2btn.setVisibility(View.GONE);
                ctHall_last_btn.setVisibility(View.GONE);

            }
        });
        go_ctHall3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent = new Intent(getApplicationContext(), cthall_talk1Activity.class);
                startActivity(intent);


                go_ctHall3btn.setVisibility(View.GONE);
                go_ctHall5btn.setVisibility(View.GONE);
                go_ctHall4btn.setVisibility(View.VISIBLE);
                go_ctHall2btn.setVisibility(View.GONE);
                ctHall_last_btn.setVisibility(View.GONE);

            }
        });

        go_ctHall4btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_ctHall3btn.setVisibility(View.GONE);
                go_ctHall5btn.setVisibility(View.VISIBLE);
                go_ctHall4btn.setVisibility(View.GONE);
                go_ctHall2btn.setVisibility(View.GONE);
                ctHall_last_btn.setVisibility(View.GONE);
            }
        }));

        go_ctHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_ctHall3btn.setVisibility(View.GONE);
                go_ctHall5btn.setVisibility(View.GONE);
                go_ctHall4btn.setVisibility(View.GONE);
                go_ctHall2btn.setVisibility(View.GONE);
                ctHall_last_btn.setVisibility(View.VISIBLE);


                Intent intent = new Intent(getApplicationContext(), cthall_talk2Activity.class);
                startActivity(intent);
            }
        });
        ctHall_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                Intent intent = new Intent(getApplicationContext(), cthall_talk3Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void showNextBackground() {
        if (currentIndex == 0) {
            ct_Background.setImageResource(imageBackground[0]);
        } else if (currentIndex == 1) {
            ct_Background.setImageResource(imageBackground[1]);
        } else if (currentIndex == 2) {
            ct_Background.setImageResource(imageBackground[2]);
        } else if (currentIndex == 3) {
            ct_Background.setImageResource(imageBackground[3]);
        } else if (currentIndex == 4) {
            ct_Background.setImageResource(imageBackground[4]);
        }
    }
}
