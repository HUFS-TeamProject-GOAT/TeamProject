package com.professionalandroid.apps.teamproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class quizexActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.quizex);
        Button finish =(Button) findViewById(R.id.finish);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
