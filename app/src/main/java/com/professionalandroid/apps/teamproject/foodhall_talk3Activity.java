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

public class foodhall_talk3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_foodhall_talk3);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_minsu = (TextView) findViewById(R.id.name_minsu);


        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);



        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button skipButton1 = (Button) findViewById(R.id.skipButton1);
        Button storyLine1Button = (Button) findViewById(R.id.food_storyLine3_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.food_storyLine3_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.food_storyLine3_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.food_storyLine3_4Button);
        Button storyLine5_Button = (Button) findViewById(R.id.food_storyLine3_5_Button);
        Button storyLine6Button = (Button) findViewById(R.id.food_storyLine3_6Button);
        Button storyLine7Button = (Button) findViewById(R.id.food_storyLine3_7Button);
        Button storyLine8_Button = (Button) findViewById(R.id.food_storyLine3_8_Button);

        TextView story1 = (TextView) findViewById(R.id.food_storyText3_1);
        TextView story2 = (TextView) findViewById(R.id.food_storyText3_2);
        TextView story3 = (TextView) findViewById(R.id.food_storyText3_3);
        TextView story4 = (TextView) findViewById(R.id.food_storyText3_4);
        TextView story5_ = (TextView) findViewById(R.id.food_storyText3_5_);
        TextView story6 = (TextView) findViewById(R.id.food_storyText3_6);
        TextView story7 = (TextView) findViewById(R.id.food_storyText3_7);
        TextView story8_ = (TextView) findViewById(R.id.food_storyText3_8_);

        hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);
                skipButton1.setVisibility(View.VISIBLE);

                hyerim.clearColorFilter();
                name_hyerim.setVisibility(View.VISIBLE);
               maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
               minsu.setVisibility(View.INVISIBLE);
               name_minsu.setVisibility(View.INVISIBLE);
               userName.setVisibility(View.INVISIBLE);

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.VISIBLE);


                Intent intent = new Intent(getApplicationContext(), stage_eg_quiz4.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5_Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.VISIBLE);

            }
        });


        storyLine1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              hyerim.clearColorFilter();

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.VISIBLE);


                name_hyerim.setVisibility(View.VISIBLE);
            }
        });
        storyLine2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility(View.VISIBLE);
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.INVISIBLE);
                minsu.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                maincharacter.clearColorFilter();

                story4.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), stage_eg_quiz4.class);
                startActivity(intent);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                minsu.setVisibility(View.INVISIBLE);
                hyerim.setVisibility(View.VISIBLE);
                hyerim.clearColorFilter();

                story5_.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.VISIBLE);

                storyLine5_Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });

        storyLine6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility(View.VISIBLE);
                maincharacter.clearColorFilter();
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story6.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);

                storyLine6Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });

        storyLine7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                minsu.setVisibility(View.INVISIBLE);
                hyerim.setVisibility(View.VISIBLE);

                story7.setVisibility(View.INVISIBLE);
                story8_.setVisibility(View.VISIBLE);

                storyLine7Button.setVisibility(View.INVISIBLE);
                storyLine8_Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });

        storyLine8_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        skipButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}