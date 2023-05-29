package com.professionalandroid.apps.teamproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ctHallActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstacestate) {
        super.onCreate(savedInstacestate);
        setContentView(R.layout.cthall);

        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_ctHall2btn = (ImageButton) findViewById(R.id.go_ctHall2btn);
        ImageButton go_ctHall3btn = (ImageButton) findViewById(R.id.go_ctHall3btn);
        ImageButton go_ctHall4btn = (ImageButton) findViewById(R.id.go_ctHall4btn);
        ImageButton go_ctHall5btn = (ImageButton) findViewById(R.id.go_ctHall5btn);
        ImageButton ctHall_last_btn = (ImageButton) findViewById(R.id.ctHall_last_btn);



        ImageView ctHall5 = (ImageView) findViewById(R.id.ctHall5);
        ImageView ctHall4 = (ImageView) findViewById(R.id.ctHall4);
        ImageView ctHall3 = (ImageView) findViewById(R.id.ctHall3);
        ImageView ctHall2 = (ImageView) findViewById(R.id.ctHall2);
        ImageView ctHall1 = (ImageView) findViewById(R.id.ctHall1);


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
            }
        });
        go_ctHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctHall2.setVisibility(View.VISIBLE);
                ctHall1.setVisibility(View.INVISIBLE);
                ctHall3.setVisibility(View.INVISIBLE);
                ctHall4.setVisibility(View.INVISIBLE);
                ctHall5.setVisibility(View.INVISIBLE);

                go_ctHall3btn.setVisibility(View.VISIBLE);
                go_ctHall4btn.setVisibility(View.INVISIBLE);
                go_ctHall5btn.setVisibility(View.INVISIBLE);
                go_ctHall2btn.setVisibility(View.INVISIBLE);
                ctHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });
        go_ctHall3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),cthall_talk1Activity.class);
                startActivity(intent);

                ctHall2.setVisibility(View.INVISIBLE);
                ctHall1.setVisibility(View.INVISIBLE);
                ctHall3.setVisibility(View.INVISIBLE);
                ctHall4.setVisibility(View.VISIBLE);
                ctHall5.setVisibility(View.INVISIBLE);

                go_ctHall3btn.setVisibility(View.INVISIBLE);
                go_ctHall4btn.setVisibility(View.INVISIBLE);
                go_ctHall5btn.setVisibility(View.VISIBLE);
                go_ctHall2btn.setVisibility(View.INVISIBLE);
                ctHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });

        go_ctHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctHall2.setVisibility(View.INVISIBLE);
                ctHall1.setVisibility(View.INVISIBLE);
                ctHall3.setVisibility(View.INVISIBLE);
                ctHall4.setVisibility(View.INVISIBLE);
                ctHall5.setVisibility(View.VISIBLE);

                go_ctHall3btn.setVisibility(View.INVISIBLE);
                go_ctHall4btn.setVisibility(View.INVISIBLE);
                go_ctHall5btn.setVisibility(View.INVISIBLE);
                go_ctHall2btn.setVisibility(View.INVISIBLE);
                ctHall_last_btn.setVisibility(View.VISIBLE);


                Intent intent =new Intent(getApplicationContext(),cthall_talk2Activity.class);
                startActivity(intent);
            }
        });
        ctHall_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(getApplicationContext(),cthall_talk3Activity.class);
                startActivity(intent1);
            }
        });


    }
}
