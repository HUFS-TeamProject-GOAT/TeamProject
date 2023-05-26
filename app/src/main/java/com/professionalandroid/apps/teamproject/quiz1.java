package com.professionalandroid.apps.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class quiz1 extends AppCompatActivity {

    private Button btn_pos3, btn_pos1, btn_pos2;
    private ImageView my_img;
    private float x, y, curr_x , curr_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        btn_pos1 = findViewById(R.id.pos1);
        btn_pos2 = findViewById(R.id.pos2);
        btn_pos3 = findViewById(R.id.pos3);

        my_img = findViewById(R.id.dk);
        my_img.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TranslateAnimation tran = new TranslateAnimation(curr_x,x,curr_y,y);
        //Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);

        curr_x = my_img.getX();
        curr_y = my_img.getY();

        btn_pos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = btn_pos3.getX();
                y = btn_pos3.getY();

                trans(curr_x,x,curr_y,y);
                //my_img.startAnimation(anim);
            }
        });

        btn_pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = btn_pos1.getX();
                y = btn_pos1.getY();

                trans(curr_x,x,curr_y,y);
            }
        });

        btn_pos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = btn_pos2.getX();
                y = btn_pos2.getY();

                trans(curr_x,x,curr_y,y);
            }
        });
    }
    public void trans(float curr_x, float x, float curr_y, float y ) {

        TranslateAnimation tran = new TranslateAnimation(curr_x,x,curr_y,y);
        tran.setDuration(1500);
        tran.setFillAfter(true);

        my_img.startAnimation(tran);

        this.curr_x = x;
        this.curr_y = y;
    }
}