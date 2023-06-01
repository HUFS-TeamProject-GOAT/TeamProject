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

public class sthall_talk4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sthall_talk4);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_minsu = (TextView) findViewById(R.id.name_minsu);
        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_security = (TextView) findViewById(R.id.name_security);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);
        ImageView security = (ImageView) findViewById(R.id.security);

        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.st_storyLine4_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.st_storyLine4_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.st_storyLine4_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.st_storyLine4_4Button);
        Button storyLine5Button = (Button) findViewById(R.id.st_storyLine4_5Button);
        Button storyLine6Button = (Button) findViewById(R.id.st_storyLine4_6Button);
        Button storyLine7Button = (Button) findViewById(R.id.st_storyLine4_7Button);
        Button storyLine8Button = (Button) findViewById(R.id.st_storyLine4_8Button);
        Button storyLine9_Button = (Button) findViewById(R.id.st_storyLine4_9_Button);
        Button storyLine10Button = (Button) findViewById(R.id.st_storyLine4_10Button);
        Button storyLine11Button = (Button) findViewById(R.id.st_storyLine4_11Button);
        Button storyLine12Button = (Button) findViewById(R.id.st_storyLine4_12Button);
        Button storyLine13Button = (Button) findViewById(R.id.st_storyLine4_13Button);
        Button storyLine14Button = (Button) findViewById(R.id.st_storyLine4_14Button);
        Button storyLine15_Button = (Button) findViewById(R.id.st_storyLine4_15_Button);




        TextView story1 = (TextView) findViewById(R.id.st_storyText4_1);
        TextView story2 = (TextView) findViewById(R.id.st_storyText4_2);
        TextView story3 = (TextView) findViewById(R.id.st_storyText4_3);
        TextView story4 = (TextView) findViewById(R.id.st_storyText4_4);
        TextView story5 = (TextView) findViewById(R.id.st_storyText4_5);
        TextView story6 = (TextView) findViewById(R.id.st_storyText4_6);
        TextView story7 = (TextView) findViewById(R.id.st_storyText4_7);
        TextView story8 = (TextView) findViewById(R.id.st_storyText4_8);
        TextView story9_ = (TextView) findViewById(R.id.st_storyText4_9_);
        TextView story10 = (TextView) findViewById(R.id.st_storyText4_10);
        TextView story11 = (TextView) findViewById(R.id.st_storyText4_11);
        TextView story12 = (TextView) findViewById(R.id.st_storyText4_12);
        TextView story13 = (TextView) findViewById(R.id.st_storyText4_13);
        TextView story14 = (TextView) findViewById(R.id.st_storyText4_14);
        TextView story15_ = (TextView) findViewById(R.id.st_storyText4_15_);



        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);
                hyerim.setVisibility(View.INVISIBLE);
                security.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
                name_security.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);


                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.INVISIBLE);
                story8.setVisibility(View.INVISIBLE);
                story9_.setVisibility(View.INVISIBLE);
                story10.setVisibility(View.VISIBLE);


                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.INVISIBLE);
                storyLine8Button.setVisibility(View.INVISIBLE);
                storyLine9_Button.setVisibility(View.INVISIBLE);
                storyLine10Button.setVisibility(View.VISIBLE);
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
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                hyerim.setVisibility((View.VISIBLE));



                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.INVISIBLE);
                security.setVisibility(View.VISIBLE);
                security.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.VISIBLE);

                name_security.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                security.clearColorFilter();

                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_security.setVisibility(View.VISIBLE);
            }
        });
        storyLine5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               security.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story5.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.VISIBLE);

                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_security.setVisibility(View.INVISIBLE);
            }
        });
        storyLine6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                security.clearColorFilter();

                story6.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);

                storyLine6Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.VISIBLE);

                name_security.setVisibility(View.VISIBLE);
            }
        });

        storyLine7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                security.setVisibility(View.INVISIBLE);
                hyerim.setVisibility(View.VISIBLE);

                story7.setVisibility(View.INVISIBLE);
                story8.setVisibility(View.VISIBLE);

                storyLine7Button.setVisibility(View.INVISIBLE);
                storyLine8Button.setVisibility(View.VISIBLE);

                name_security.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });
        storyLine8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story8.setVisibility(View.INVISIBLE);
                story9_.setVisibility(View.VISIBLE);

                storyLine8Button.setVisibility(View.INVISIBLE);
                storyLine9_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine9_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);

                maincharacter.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story9_.setVisibility(View.INVISIBLE);
                story10.setVisibility(View.VISIBLE);

                storyLine9_Button.setVisibility(View.INVISIBLE);
                storyLine10Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                hyerim.setVisibility(View.INVISIBLE);
                security.setVisibility(View.VISIBLE);
                security.clearColorFilter();

                story10.setVisibility(View.INVISIBLE);
                story11.setVisibility(View.VISIBLE);

                storyLine10Button.setVisibility(View.INVISIBLE);
                storyLine11Button.setVisibility(View.VISIBLE);

                name_security.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);

            }
        });
        storyLine11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                security.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story11.setVisibility(View.INVISIBLE);
                story12.setVisibility(View.VISIBLE);

                storyLine11Button.setVisibility(View.INVISIBLE);
                storyLine12Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_security.setVisibility(View.INVISIBLE);
            }
        });
        storyLine12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                security.setVisibility(View.INVISIBLE);
                hyerim.setVisibility(View.VISIBLE);
                hyerim.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story12.setVisibility(View.INVISIBLE);
                story13.setVisibility(View.VISIBLE);

                storyLine12Button.setVisibility(View.INVISIBLE);
                storyLine13Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });
        storyLine13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.INVISIBLE);
                minsu.setVisibility(View.VISIBLE);

                story13.setVisibility(View.INVISIBLE);
                story14.setVisibility(View.VISIBLE);

                storyLine13Button.setVisibility(View.INVISIBLE);
                storyLine14Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story14.setVisibility(View.INVISIBLE);
                story15_.setVisibility(View.VISIBLE);

                storyLine14Button.setVisibility(View.INVISIBLE);
                storyLine15_Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine15_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}