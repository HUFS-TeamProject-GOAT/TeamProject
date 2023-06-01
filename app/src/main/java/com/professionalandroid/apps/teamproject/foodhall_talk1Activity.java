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

public class foodhall_talk1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_foodhall_talk1);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_minsu = (TextView) findViewById(R.id.name_minsu);
        TextView name_hyungchan = (TextView) findViewById(R.id.name_hyungchan);
        TextView name_hyunggu = (TextView) findViewById(R.id.name_hyunggu);
        TextView name_professor = (TextView) findViewById(R.id.name_professor);
        TextView name_extra = (TextView) findViewById(R.id.name_extra);
        TextView name_security = (TextView) findViewById(R.id.name_security);
        TextView name_nutrician = (TextView) findViewById(R.id.name_nutrician);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);
        ImageView  hyungchan= (ImageView) findViewById(R.id.hyungchan);
        ImageView hyunggu = (ImageView) findViewById(R.id.hyunggu);
        ImageView professor = (ImageView) findViewById(R.id.professor);
        ImageView  extra = (ImageView) findViewById(R.id.extra);
        ImageView security = (ImageView) findViewById(R.id.security);
        ImageView nutrician = (ImageView) findViewById(R.id.nutrician);
        ImageView extra2 = (ImageView) findViewById(R.id.extra2);


        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.food_storyLine1_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.food_storyLine1_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.food_storyLine1_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.food_storyLine1_4Button);
        Button storyLine5Button = (Button) findViewById(R.id.food_storyLine1_5Button);
        Button storyLine6_Button = (Button) findViewById(R.id.food_storyLine1_6_Button);
        Button storyLine7Button = (Button) findViewById(R.id.food_storyLine1_7Button);
        Button storyLine8Button = (Button) findViewById(R.id.food_storyLine1_8Button);
        Button storyLine9_Button = (Button) findViewById(R.id.food_storyLine1_9_Button);


        TextView story1 = (TextView) findViewById(R.id.food_storyText1_1);
        TextView story2 = (TextView) findViewById(R.id.food_storyText1_2);
        TextView story3 = (TextView) findViewById(R.id.food_storyText1_3);
        TextView story4 = (TextView) findViewById(R.id.food_storyText1_4);
        TextView story5 = (TextView) findViewById(R.id.food_storyText1_5);
        TextView story6_ = (TextView) findViewById(R.id.food_storyText1_6_);
        TextView story7 = (TextView) findViewById(R.id.food_storyText1_7);
        TextView story8 = (TextView) findViewById(R.id.food_storyText1_8);
        TextView story9_ = (TextView) findViewById(R.id.food_storyText1_9_);

        hyunggu.setVisibility(View.VISIBLE);
        hyunggu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);

                hyunggu.setVisibility(View.INVISIBLE);
                extra.setVisibility(View.INVISIBLE);
                extra2.setVisibility(View.INVISIBLE);

                maincharacter.setVisibility(View.VISIBLE);
                userName.setVisibility(View.VISIBLE);

                name_extra.setVisibility(View.INVISIBLE);


                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.INVISIBLE);
                story6_.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);


                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6_Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.VISIBLE);

            }
        });


        storyLine1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyunggu.setVisibility(View.INVISIBLE);
                extra.setVisibility((View.VISIBLE));

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.VISIBLE);


                name_extra.setVisibility(View.VISIBLE);
            }
        });
        storyLine2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extra2.setVisibility((View.VISIBLE));
                extra.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);

                name_extra.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extra.clearColorFilter();
                extra2.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.VISIBLE);

                name_extra.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extra2.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);
                extra.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_extra.setVisibility(View.INVISIBLE);
            }
        });
        storyLine5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                extra.clearColorFilter();

                story5.setVisibility(View.INVISIBLE);
                story6_.setVisibility(View.VISIBLE);

                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_extra.setVisibility(View.VISIBLE);
            }
        });

        storyLine6_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);
                maincharacter.clearColorFilter();
                extra.setVisibility(View.INVISIBLE);

                story6_.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);

                storyLine6_Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_extra.setVisibility(View.INVISIBLE);
            }
        });

        storyLine7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story7.setVisibility(View.INVISIBLE);
                story8.setVisibility(View.VISIBLE);

                storyLine7Button.setVisibility(View.INVISIBLE);
                storyLine8Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story8.setVisibility(View.INVISIBLE);
                story9_.setVisibility(View.VISIBLE);

                storyLine8Button.setVisibility(View.INVISIBLE);
                storyLine9_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine9_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}