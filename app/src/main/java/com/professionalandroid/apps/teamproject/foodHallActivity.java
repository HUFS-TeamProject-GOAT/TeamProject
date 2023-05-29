package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class foodHallActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.foodhall);

        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_foodHall2btn = (ImageButton) findViewById(R.id.go_foodHall2btn);
        ImageButton go_foodHall3btn = (ImageButton) findViewById(R.id.go_foodHall3btn);
        ImageButton go_foodHall4btn = (ImageButton) findViewById(R.id.go_foodHall4btn);
        ImageButton go_foodHall5btn = (ImageButton) findViewById(R.id.go_foodHall5btn);
        ImageButton foodHall_last_btn = (ImageButton) findViewById(R.id.foodHall_last_btn);



        ImageView foodHall5 = (ImageView) findViewById(R.id.foodHall5);
        ImageView foodHall4 = (ImageView) findViewById(R.id.foodHall4);
        ImageView foodHall3 = (ImageView) findViewById(R.id.foodHall3);
        ImageView foodHall2 = (ImageView) findViewById(R.id.foodHall2);
        ImageView foodHall1 = (ImageView) findViewById(R.id.foodHall1);


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
            }
        });
        go_foodHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodHall2.setVisibility(View.VISIBLE);
                foodHall1.setVisibility(View.INVISIBLE);
                foodHall3.setVisibility(View.INVISIBLE);
                foodHall4.setVisibility(View.INVISIBLE);
                foodHall5.setVisibility(View.INVISIBLE);

                go_foodHall3btn.setVisibility(View.VISIBLE);
                go_foodHall4btn.setVisibility(View.INVISIBLE);
                go_foodHall5btn.setVisibility(View.INVISIBLE);
                go_foodHall2btn.setVisibility(View.INVISIBLE);
                foodHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_foodHall3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodHall2.setVisibility(View.INVISIBLE);
                foodHall1.setVisibility(View.INVISIBLE);
                foodHall3.setVisibility(View.INVISIBLE);
                foodHall4.setVisibility(View.VISIBLE);
                foodHall5.setVisibility(View.INVISIBLE);

                go_foodHall3btn.setVisibility(View.INVISIBLE);
                go_foodHall4btn.setVisibility(View.INVISIBLE);
                go_foodHall5btn.setVisibility(View.VISIBLE);
                go_foodHall2btn.setVisibility(View.INVISIBLE);
                foodHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_foodHall4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodHall2.setVisibility(View.INVISIBLE);
                foodHall1.setVisibility(View.INVISIBLE);
                foodHall3.setVisibility(View.INVISIBLE);
                foodHall4.setVisibility(View.VISIBLE);
                foodHall5.setVisibility(View.INVISIBLE);

                go_foodHall3btn.setVisibility(View.INVISIBLE);
                go_foodHall4btn.setVisibility(View.VISIBLE);
                go_foodHall5btn.setVisibility(View.INVISIBLE);
                go_foodHall2btn.setVisibility(View.INVISIBLE);
                foodHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_foodHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodHall2.setVisibility(View.INVISIBLE);
                foodHall1.setVisibility(View.INVISIBLE);
                foodHall3.setVisibility(View.INVISIBLE);
                foodHall4.setVisibility(View.INVISIBLE);
                foodHall5.setVisibility(View.VISIBLE);

                go_foodHall3btn.setVisibility(View.INVISIBLE);
                go_foodHall4btn.setVisibility(View.INVISIBLE);
                go_foodHall5btn.setVisibility(View.INVISIBLE);
                go_foodHall2btn.setVisibility(View.INVISIBLE);
                foodHall_last_btn.setVisibility(View.VISIBLE);

            }
        });

    }
}
