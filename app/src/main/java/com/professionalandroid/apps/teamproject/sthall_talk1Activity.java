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

public class sthall_talk1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sthall_talk1);

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
        Button storyLine1Button = (Button) findViewById(R.id.st_storyLine1_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.st_storyLine1_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.st_storyLine1_3Button);
        Button storyLine4_Button = (Button) findViewById(R.id.st_storyLine1_4_Button);
        Button storyLine5_Button = (Button) findViewById(R.id.st_storyLine1_5_Button);


        TextView story1 = (TextView) findViewById(R.id.st_storyText1_1);
        TextView story2 = (TextView) findViewById(R.id.st_storyText1_2);
        TextView story3 = (TextView) findViewById(R.id.st_storyText1_3);
        TextView story4_ = (TextView) findViewById(R.id.st_storyText1_4_);
        TextView story5_ = (TextView) findViewById(R.id.st_storyText1_5_);


        maincharacter.setVisibility((View.VISIBLE));
        maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

        minsu.setVisibility((View.VISIBLE));
        minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);


                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4_.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.VISIBLE);


                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4_Button.setVisibility(View.INVISIBLE);
                storyLine5_Button.setVisibility(View.VISIBLE);

            }
        });


        storyLine1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               minsu.clearColorFilter();

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.VISIBLE);


                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility((View.VISIBLE));
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.VISIBLE);
                minsu.setVisibility(View.INVISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story3.setVisibility(View.INVISIBLE);
                story4_.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4_Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), st_quiz_3.class);
                startActivity(intent);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                hyerim.setVisibility(View.INVISIBLE);

                story4_.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.VISIBLE);

                storyLine4_Button.setVisibility(View.INVISIBLE);
                storyLine5_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}