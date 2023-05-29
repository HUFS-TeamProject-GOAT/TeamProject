package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class egHallActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.eghall);

        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_egHall2btn = (ImageButton) findViewById(R.id.go_egHall2btn);
        ImageButton go_egHall3btn = (ImageButton) findViewById(R.id.go_egHall3btn);
        ImageButton go_egHall4btn = (ImageButton) findViewById(R.id.go_egHall4btn);
        ImageButton go_egHall5btn = (ImageButton) findViewById(R.id.go_egHall5btn);
        ImageButton egHall_last_btn = (ImageButton) findViewById(R.id.egHall_last_btn);



        ImageView egHall5 = (ImageView) findViewById(R.id.egHall5);
        ImageView egHall4 = (ImageView) findViewById(R.id.egHall4);
        ImageView egHall3 = (ImageView) findViewById(R.id.egHall3);
        ImageView egHall2 = (ImageView) findViewById(R.id.egHall2);
        ImageView egHall1 = (ImageView) findViewById(R.id.egHall1);


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
            }
        });
        go_egHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                egHall2.setVisibility(View.VISIBLE);
                egHall1.setVisibility(View.INVISIBLE);
                egHall3.setVisibility(View.INVISIBLE);
                egHall4.setVisibility(View.INVISIBLE);
                egHall5.setVisibility(View.INVISIBLE);

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
                egHall2.setVisibility(View.INVISIBLE);
                egHall1.setVisibility(View.INVISIBLE);
                egHall3.setVisibility(View.INVISIBLE);
                egHall4.setVisibility(View.VISIBLE);
                egHall5.setVisibility(View.INVISIBLE);

                go_egHall3btn.setVisibility(View.INVISIBLE);
                go_egHall4btn.setVisibility(View.INVISIBLE);
                go_egHall5btn.setVisibility(View.VISIBLE);
                go_egHall2btn.setVisibility(View.INVISIBLE);
                egHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_egHall4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                egHall2.setVisibility(View.INVISIBLE);
                egHall1.setVisibility(View.INVISIBLE);
                egHall3.setVisibility(View.INVISIBLE);
                egHall4.setVisibility(View.VISIBLE);
                egHall5.setVisibility(View.INVISIBLE);

                go_egHall3btn.setVisibility(View.INVISIBLE);
                go_egHall4btn.setVisibility(View.VISIBLE);
                go_egHall5btn.setVisibility(View.INVISIBLE);
                go_egHall2btn.setVisibility(View.INVISIBLE);
                egHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_egHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                egHall2.setVisibility(View.INVISIBLE);
                egHall1.setVisibility(View.INVISIBLE);
                egHall3.setVisibility(View.INVISIBLE);
                egHall4.setVisibility(View.INVISIBLE);
                egHall5.setVisibility(View.VISIBLE);

                go_egHall3btn.setVisibility(View.INVISIBLE);
                go_egHall4btn.setVisibility(View.INVISIBLE);
                go_egHall5btn.setVisibility(View.INVISIBLE);
                go_egHall2btn.setVisibility(View.INVISIBLE);
                egHall_last_btn.setVisibility(View.VISIBLE);

            }
        });

    }
}
