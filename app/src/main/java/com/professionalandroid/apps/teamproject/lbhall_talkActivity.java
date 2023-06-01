package com.professionalandroid.apps.teamproject;



import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lbhall_talkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_lbhall_talk);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);


        TextView name_president = (TextView) findViewById(R.id.name_president);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView president= (ImageView) findViewById(R.id.president);

        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.lb_storyLine1_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.lb_storyLine1_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.lb_storyLine1_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.lb_storyLine1_4Button);
        Button storyLine5Button = (Button) findViewById(R.id.lb_storyLine1_5Button);
        Button storyLine6_Button = (Button) findViewById(R.id.lb_storyLine1_6_Button);


        TextView story1 = (TextView) findViewById(R.id.lb_storyText1_1);
        TextView story2 = (TextView) findViewById(R.id.lb_storyText1_2);
        TextView story3 = (TextView) findViewById(R.id.lb_storyText1_3);
        TextView story4 = (TextView) findViewById(R.id.lb_storyText1_4);
        TextView story5 = (TextView) findViewById(R.id.lb_storyText1_5);
        TextView story6_ = (TextView) findViewById(R.id.lb_storyText1_6_);


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.INVISIBLE);
                story6_.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6_Button.setVisibility(View.VISIBLE);

                Intent intent = new Intent(getApplicationContext(), endingActivity.class);
                startActivity(intent);

            }
        });


        storyLine1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               president.setVisibility((View.VISIBLE));

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.VISIBLE);


                name_president.setVisibility(View.VISIBLE);
            }
        });
        storyLine2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               president.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                maincharacter.setVisibility(View.VISIBLE);

                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
                name_president.setVisibility(View.INVISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                president.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.VISIBLE);

                name_president.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                president.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_president.setVisibility(View.INVISIBLE);
            }
        });
        storyLine5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                president.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story5.setVisibility(View.INVISIBLE);
                story6_.setVisibility(View.VISIBLE);

                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_president.setVisibility(View.VISIBLE);
            }
        });
        storyLine6_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), endingActivity.class);
                startActivity(intent);
            }
        });
    }

}