package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class lakeActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lake);

        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_lake2btn = (ImageButton) findViewById(R.id.go_lake2btn);
        ImageButton go_lake3btn = (ImageButton) findViewById(R.id.go_lake3btn);
        ImageButton lake_last_btn = (ImageButton) findViewById(R.id.lake_last_btn);


        ImageView lake3 = (ImageView) findViewById(R.id.lake3);
        ImageView lake2 = (ImageView) findViewById(R.id.lake2);
        ImageView lake1 = (ImageView) findViewById(R.id.lake1);


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
            }
        });
        go_lake2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lake2.setVisibility(View.VISIBLE);
                lake1.setVisibility(View.INVISIBLE);
                lake3.setVisibility(View.INVISIBLE);

                go_lake3btn.setVisibility(View.VISIBLE);
                go_lake2btn.setVisibility(View.INVISIBLE);
                lake_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_lake3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lake2.setVisibility(View.INVISIBLE);
                lake1.setVisibility(View.INVISIBLE);
                lake3.setVisibility(View.VISIBLE);

                go_lake3btn.setVisibility(View.INVISIBLE);
                go_lake2btn.setVisibility(View.INVISIBLE);
                lake_last_btn.setVisibility(View.VISIBLE);


            }
        });
        lake_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),lake_talkActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
