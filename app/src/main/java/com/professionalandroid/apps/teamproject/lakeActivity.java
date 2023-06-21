package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import  android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class lakeActivity extends AppCompatActivity {

    private int currentIndex = 0;
    private final int[] imageBackground = {R.drawable.lake1, R.drawable.lake2, R.drawable.lake3};
    private ImageView lake_Background;
    public MediaPlayer clickPlay;
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lake);
        clickPlay = MediaPlayer.create(this, R.raw.click);

        lake_Background = findViewById(R.id.lake_Background);
        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_lake2btn = (ImageButton) findViewById(R.id.go_lake2btn);
        ImageButton go_lake3btn = (ImageButton) findViewById(R.id.go_lake3btn);
        ImageButton lake_last_btn = (ImageButton) findViewById(R.id.lake_last_btn);
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
        go_lake2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_lake3btn.setVisibility(View.VISIBLE);
                go_lake2btn.setVisibility(View.INVISIBLE);
                lake_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_lake3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                currentIndex++;
                showNextBackground();

                go_lake3btn.setVisibility(View.INVISIBLE);
                go_lake2btn.setVisibility(View.INVISIBLE);
                lake_last_btn.setVisibility(View.VISIBLE);

            }
        });
        lake_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                currentIndex++;
                showNextBackground();
                Intent intent =new Intent(getApplicationContext(),lake_talkActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void showNextBackground() {
        if (currentIndex == 0) {
            lake_Background.setImageResource(imageBackground[0]);
        }
        else if (currentIndex == 1) {
            lake_Background.setImageResource(imageBackground[1]);
        }
        else if (currentIndex == 2) {
            lake_Background.setImageResource(imageBackground[2]);
        }
    }
}
