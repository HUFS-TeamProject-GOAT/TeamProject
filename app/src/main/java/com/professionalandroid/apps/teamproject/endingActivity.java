package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class endingActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_ending);
        Button MainButton = (Button) findViewById(R.id.MainButton);
        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
