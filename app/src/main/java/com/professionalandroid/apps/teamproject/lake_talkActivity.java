package com.professionalandroid.apps.teamproject;



import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorFilter;
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

public class lake_talkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_lake_talk);

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
        ImageView hyungchan = (ImageView) findViewById(R.id.hyungchan);
        ImageView hyunggu = (ImageView) findViewById(R.id.hyunggu);
        ImageView professor = (ImageView) findViewById(R.id.professor);
        ImageView extra = (ImageView) findViewById(R.id.extra);
        ImageView security = (ImageView) findViewById(R.id.security);
        ImageView nutrician = (ImageView) findViewById(R.id.nutrician);


        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.lake_storyLine1_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.lake_storyLine1_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.lake_storyLine1_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.lake_storyLine1_4Button);
        Button storyLine5_Button = (Button) findViewById(R.id.lake_storyLine1_5_Button);
        Button storyLine6Button = (Button) findViewById(R.id.lake_storyLine1_6Button);
        Button storyLine7Button = (Button) findViewById(R.id.lake_storyLine1_7Button);
        Button storyLine8Button = (Button) findViewById(R.id.lake_storyLine1_8Button);
        Button storyLine9_Button = (Button) findViewById(R.id.lake_storyLine1_9_Button);

        TextView story1 = (TextView) findViewById(R.id.lake_storyText1_1);
        TextView story2 = (TextView) findViewById(R.id.lake_storyText1_2);
        TextView story3 = (TextView) findViewById(R.id.lake_storyText1_3);
        TextView story4 = (TextView) findViewById(R.id.lake_storyText1_4);
        TextView story5_ = (TextView) findViewById(R.id.lake_storyText1_5_);
        TextView story6 = (TextView) findViewById(R.id.lake_storyText1_6);
        TextView story7 = (TextView) findViewById(R.id.lake_storyText1_7);
        TextView story8 = (TextView) findViewById(R.id.lake_storyText1_8);
        TextView story9_ = (TextView) findViewById(R.id.lake_storyText1_9_);


        maincharacter.setVisibility(View.VISIBLE);
        extra.setVisibility(View.VISIBLE);

        extra.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
        maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);

                minsu.setVisibility(View.VISIBLE);
                minsu.clearColorFilter();
                hyerim.setVisibility(View.INVISIBLE);
                extra.setVisibility(View.INVISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                name_minsu.setVisibility(View.VISIBLE);
                name_extra.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.INVISIBLE);


                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.VISIBLE);


                Intent intent = new Intent(getApplicationContext(), ct_quiz_4.class);
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
               extra.clearColorFilter();

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
                extra.setVisibility(View.INVISIBLE);
                minsu.setVisibility(View.VISIBLE);

                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);

                name_extra.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.VISIBLE);
                minsu.setVisibility(View.INVISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story4.setVisibility(View.INVISIBLE);
                story5_.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });
        storyLine5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fd_quiz_4.class);
                startActivity(intent);
                hyerim.setVisibility(View.INVISIBLE);
                minsu.setVisibility(View.VISIBLE);
                minsu.clearColorFilter();

                story5_.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.VISIBLE);

                storyLine5_Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });

        storyLine6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility(View.VISIBLE);
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                maincharacter.clearColorFilter();

                story6.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);

                storyLine6Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });

        storyLine7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.INVISIBLE);
                hyerim.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story7.setVisibility(View.INVISIBLE);
                story8.setVisibility(View.VISIBLE);

                storyLine7Button.setVisibility(View.INVISIBLE);
                storyLine8Button.setVisibility(View.VISIBLE);

               name_hyerim.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
               maincharacter.clearColorFilter();


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
                Intent intent = new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}