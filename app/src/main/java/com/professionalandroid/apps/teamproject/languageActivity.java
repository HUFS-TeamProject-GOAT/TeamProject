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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class languageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        Button backButton = findViewById(R.id.backButton);
        Button koreanButton = findViewById(R.id.koreanButton);
        Button englishButton = findViewById(R.id.englishButton);

        koreanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("ko");
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

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("en");
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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}