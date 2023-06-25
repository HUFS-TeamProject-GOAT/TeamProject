package com.professionalandroid.apps.teamproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class languageActivity extends AppCompatActivity {

    public MediaPlayer clickPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        Button backButton = findViewById(R.id.backButton);
        Button koreanButton = findViewById(R.id.koreanButton);
        Button englishButton = findViewById(R.id.englishButton);
        clickPlay = MediaPlayer.create(this, R.raw.click);

        koreanButton.setOnClickListener(new View.OnClickListener() { //누르면 한국어로 게임이 진행됨
            @Override
            public void onClick(View v) {
                clickPlay.start();
                Locale locale = new Locale("ko"); //한국어 스트링 리소스 파일 참조
                Configuration config = getResources().getConfiguration();
                if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 ) {
                    config.setLocale(locale);
                }
                else {
                    config.locale = locale;
                }
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                recreate();
            }
        });

        englishButton.setOnClickListener(new View.OnClickListener() { //영어 버튼을 클릭하는 경우
            @Override
            public void onClick(View v) {
                clickPlay.start();
                Locale locale = new Locale("en"); //영어 리소스 파일참조
                Configuration config = getResources().getConfiguration();
                if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 ) {
                    config.setLocale(locale);
                }
                else {
                    config.locale = locale;
                }
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                recreate();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //돌아가기 버튼으로 제일 처음 화면으로 돌아감
                clickPlay.start();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}