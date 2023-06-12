package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class foodHallActivity extends AppCompatActivity {

    private int currentIndex = 0;
    private final int[] imageBackground = {R.drawable.foodhall1, R.drawable.foodhall2, R.drawable.foodhall3, R.drawable.foodhall4, R.drawable.foodhall5};
    private ImageView food_Background;
    protected void onCreate(Bundle savedInstacestate) {
        super.onCreate(savedInstacestate);
        setContentView(R.layout.foodhall);

        food_Background = findViewById(R.id.food_Background);
        ImageButton go_home_btn = (ImageButton) findViewById(R.id.go_home_btn);
        ImageButton go_foodHall2btn = (ImageButton) findViewById(R.id.go_foodHall2btn);
        ImageButton go_foodHall3btn = (ImageButton) findViewById(R.id.go_foodHall3btn);
        ImageButton go_foodHall4btn = (ImageButton) findViewById(R.id.go_foodHall4btn);
        ImageButton go_foodHall5btn = (ImageButton) findViewById(R.id.go_foodHall5btn);
        ImageButton foodHall_last_btn = (ImageButton) findViewById(R.id.foodHall_last_btn);
        showNextBackground();


        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        go_foodHall2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();

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
                currentIndex++;
                showNextBackground();

                Intent intent =new Intent(getApplicationContext(),foodhall_talk1Activity.class);
                startActivity(intent);


                go_foodHall3btn.setVisibility(View.INVISIBLE);
                go_foodHall4btn.setVisibility(View.INVISIBLE);
                go_foodHall5btn.setVisibility(View.VISIBLE);
                go_foodHall2btn.setVisibility(View.INVISIBLE);
                foodHall_last_btn.setVisibility(View.INVISIBLE);

            }
        });

        go_foodHall5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();

                go_foodHall3btn.setVisibility(View.INVISIBLE);
                go_foodHall4btn.setVisibility(View.INVISIBLE);
                go_foodHall5btn.setVisibility(View.INVISIBLE);
                go_foodHall2btn.setVisibility(View.INVISIBLE);
                foodHall_last_btn.setVisibility(View.VISIBLE);


                Intent intent =new Intent(getApplicationContext(),foodhall_talk2Activity.class);
                startActivity(intent);
            }
        });
        foodHall_last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                showNextBackground();
                Intent intent1 =new Intent(getApplicationContext(),foodhall_talk3Activity.class);
                startActivity(intent1);
                finish();
            }
        });


    }

    private void showNextBackground() {
        if (currentIndex == 0) {
            food_Background.setImageResource(imageBackground[0]);
        }
        else if (currentIndex == 1) {
            food_Background.setImageResource(imageBackground[1]);
        }
        else if (currentIndex == 2) {
            food_Background.setImageResource(imageBackground[2]);
        }
        else if (currentIndex == 3) {
            food_Background.setImageResource(imageBackground[3]);
        }else if (currentIndex == 4) {
            food_Background.setImageResource(imageBackground[4]);
        }
    }
}