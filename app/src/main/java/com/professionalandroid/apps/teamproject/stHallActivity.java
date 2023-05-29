package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class stHallActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sthall);

        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_stHall2btn = (ImageButton) findViewById(R.id.go_stHall2btn);
        ImageButton go_stHall3btn = (ImageButton) findViewById(R.id.go_stHall3btn);
        ImageButton go_stHall4btn = (ImageButton) findViewById(R.id.go_stHall4btn);
        ImageButton go_stHall5btn = (ImageButton) findViewById(R.id.go_stHall5btn);
        ImageButton stHall_last_btn = (ImageButton) findViewById(R.id.stHall_last_btn);



        ImageView stHall5 = (ImageView) findViewById(R.id.stHall5);
        ImageView stHall4 = (ImageView) findViewById(R.id.stHall4);
        ImageView stHall3 = (ImageView) findViewById(R.id.stHall3);
        ImageView stHall2 = (ImageView) findViewById(R.id.stHall2);
        ImageView stHall1 = (ImageView) findViewById(R.id.stHall1);


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
            }
        });
        go_stHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stHall2.setVisibility(View.VISIBLE);
                stHall1.setVisibility(View.INVISIBLE);
                stHall3.setVisibility(View.INVISIBLE);
                stHall4.setVisibility(View.INVISIBLE);
                stHall5.setVisibility(View.INVISIBLE);

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
                stHall2.setVisibility(View.INVISIBLE);
                stHall1.setVisibility(View.INVISIBLE);
                stHall3.setVisibility(View.INVISIBLE);
                stHall4.setVisibility(View.VISIBLE);
                stHall5.setVisibility(View.INVISIBLE);

                go_stHall3btn.setVisibility(View.INVISIBLE);
                go_stHall4btn.setVisibility(View.INVISIBLE);
                go_stHall5btn.setVisibility(View.VISIBLE);
                go_stHall2btn.setVisibility(View.INVISIBLE);
                stHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_stHall4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stHall2.setVisibility(View.INVISIBLE);
                stHall1.setVisibility(View.INVISIBLE);
                stHall3.setVisibility(View.INVISIBLE);
                stHall4.setVisibility(View.VISIBLE);
                stHall5.setVisibility(View.INVISIBLE);

                go_stHall3btn.setVisibility(View.INVISIBLE);
                go_stHall4btn.setVisibility(View.VISIBLE);
                go_stHall5btn.setVisibility(View.INVISIBLE);
                go_stHall2btn.setVisibility(View.INVISIBLE);
                stHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_stHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stHall2.setVisibility(View.INVISIBLE);
                stHall1.setVisibility(View.INVISIBLE);
                stHall3.setVisibility(View.INVISIBLE);
                stHall4.setVisibility(View.INVISIBLE);
                stHall5.setVisibility(View.VISIBLE);

                go_stHall3btn.setVisibility(View.INVISIBLE);
                go_stHall4btn.setVisibility(View.INVISIBLE);
                go_stHall5btn.setVisibility(View.INVISIBLE);
                go_stHall2btn.setVisibility(View.INVISIBLE);
                stHall_last_btn.setVisibility(View.VISIBLE);

            }
        });

    }
}
