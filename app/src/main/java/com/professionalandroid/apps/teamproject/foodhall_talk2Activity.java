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

public class foodhall_talk2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_foodhall_talk2);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_minsu = (TextView) findViewById(R.id.name_minsu);
        TextView name_nutrician = (TextView) findViewById(R.id.name_nutrician);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);
        ImageView nutrician = (ImageView) findViewById(R.id.nutrician);


        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.food_storyLine2_1Button);
        Button storyLine2_Button = (Button) findViewById(R.id.food_storyLine2_2_Button);
        Button storyLine3Button = (Button) findViewById(R.id.food_storyLine2_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.food_storyLine2_4Button);
        Button storyLine5Button = (Button) findViewById(R.id.food_storyLine2_5Button);
        Button storyLine6Button = (Button) findViewById(R.id.food_storyLine2_6Button);
        Button storyLine7_Button = (Button) findViewById(R.id.food_storyLine2_7_Button);


        TextView story1 = (TextView) findViewById(R.id.food_storyText2_1);
        TextView story2_ = (TextView) findViewById(R.id.food_storyText2_2_);
        TextView story3 = (TextView) findViewById(R.id.food_storyText2_3);
        TextView story4 = (TextView) findViewById(R.id.food_storyText2_4);
        TextView story5 = (TextView) findViewById(R.id.food_storyText2_5);
        TextView story6_ = (TextView) findViewById(R.id.food_storyText2_6);
        TextView story7 = (TextView) findViewById(R.id.food_storyText2_7_);


        nutrician.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);

                nutrician.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);
                minsu.setVisibility(View.VISIBLE);
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                userName.setVisibility(View.INVISIBLE);
                name_nutrician.setVisibility(View.INVISIBLE);

                story1.setVisibility(View.INVISIBLE);
                story2_.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);



                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2_Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);

            }
        });


        storyLine1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nutrician.clearColorFilter();

                story1.setVisibility(View.INVISIBLE);
                story2_.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2_Button.setVisibility(View.VISIBLE);


                name_nutrician.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);
                nutrician.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);

                story2_.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2_Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
                name_nutrician.setVisibility(View.INVISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.VISIBLE);
               minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
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

                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story5.setVisibility(View.INVISIBLE);
                story6_.setVisibility(View.VISIBLE);

                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });

        storyLine6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story6_.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);

                storyLine6Button.setVisibility(View.INVISIBLE);
                storyLine7_Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });

        storyLine7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });


    }

}