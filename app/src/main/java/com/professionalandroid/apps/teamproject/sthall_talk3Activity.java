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

public class sthall_talk3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sthall_talk3);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_professor = (TextView) findViewById(R.id.name_professor);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView professor= (ImageView) findViewById(R.id.professor);

        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.st_storyLine3_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.st_storyLine3_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.st_storyLine3_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.st_storyLine3_4Button);
        Button storyLine5_Button = (Button) findViewById(R.id.st_storyLine3_5_Button);
        Button storyLine6_Button = (Button) findViewById(R.id.st_storyLine3_6_Button);


        TextView story1 = (TextView) findViewById(R.id.st_storyText3_1);
        TextView story2 = (TextView) findViewById(R.id.st_storyText3_2);
        TextView story3 = (TextView) findViewById(R.id.st_storyText3_3);
        TextView story4 = (TextView) findViewById(R.id.st_storyText3_4);
        TextView story5_ = (TextView) findViewById(R.id.st_storyText3_5_);
        TextView story6_ = (TextView) findViewById(R.id.st_storyText3_6_);


        professor.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                maincharacter.setVisibility(View.VISIBLE);
                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
                name_professor.setVisibility(View.INVISIBLE);

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.INVISIBLE);
                story6_.setVisibility(View.VISIBLE);

                Intent intent = new Intent(getApplicationContext(), st_quiz_3.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5_Button.setVisibility(View.INVISIBLE);
                storyLine6_Button.setVisibility(View.VISIBLE);


            }
        });


        storyLine1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility((View.VISIBLE));

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.INVISIBLE);
                name_professor.setVisibility(View.VISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setVisibility(View.INVISIBLE);
                hyerim.setVisibility(View.VISIBLE);


                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.VISIBLE);
                name_professor.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setVisibility(View.VISIBLE);
                hyerim.setVisibility(View.INVISIBLE);

                story4.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5_Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.INVISIBLE);
                name_professor.setVisibility(View.VISIBLE);
            }
        });
        storyLine5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), st_quiz_3.class);
                startActivity(intent);
                maincharacter.setVisibility(View.VISIBLE);
               maincharacter.clearColorFilter();
               professor.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story5_.setVisibility(View.INVISIBLE);
                story6_.setVisibility(View.VISIBLE);

                storyLine5_Button.setVisibility(View.INVISIBLE);
                storyLine6_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_professor.setVisibility(View.INVISIBLE);
            }
        });
        storyLine6_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

}