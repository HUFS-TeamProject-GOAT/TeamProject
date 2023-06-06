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

public class cthall_talk2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_cthall_talk2);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName =(TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_professor = (TextView) findViewById(R.id.name_professor);
        TextView name_minsu =(TextView) findViewById(R.id.name_minsu);
        TextView name_hyunggu =(TextView) findViewById(R.id.name_hyunggu);


        Button skipButton = (Button) findViewById(R.id.ct_skipButton);
        Button skipButton1 = (Button) findViewById(R.id.ct_skipButton1);

        Button storyLine2_1Button = (Button) findViewById(R.id.ct_storyLine2_1Button);
        Button storyLine2_2Button = (Button) findViewById(R.id.ct_storyLine2_2Button);
        Button storyLine2_3_Button = (Button) findViewById(R.id.ct_storyLine2_3_Button);
        Button storyLine2_4Button = (Button) findViewById(R.id.ct_storyLine2_4Button);
        Button storyLine2_5Button = (Button) findViewById(R.id.ct_storyLine2_5Button);
        Button storyLine2_6_Button = (Button) findViewById(R.id.ct_storyLine2_6_Button);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView professor = (ImageView) findViewById(R.id.professor);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);
        ImageView hyunggu = (ImageView) findViewById(R.id.hyunggu);


        TextView story2_1 =(TextView) findViewById(R.id.ct_storyText2_1);
        TextView story2_2 =(TextView) findViewById(R.id.ct_storyText2_2);
        TextView story2_3_ =(TextView) findViewById(R.id.ct_storyText2_3_);
        TextView story2_4 =(TextView) findViewById(R.id.ct_storyText2_4);
        TextView story2_5 =(TextView) findViewById(R.id.ct_storyText2_5);
        TextView story2_6_ =(TextView) findViewById(R.id.ct_storyText2_6_);

        skipButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);
                skipButton1.setVisibility(View.VISIBLE);

                professor.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);
                maincharacter.clearColorFilter();
                name_professor.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);

                Intent intent =new Intent(getApplicationContext(),stage_eg_quiz2.class);
                startActivity(intent);
                story2_1.setVisibility(View.INVISIBLE);
                story2_2.setVisibility(View.INVISIBLE);
                story2_3_.setVisibility(View.INVISIBLE);
                story2_4.setVisibility(View.VISIBLE);

                storyLine2_1Button.setVisibility(View.INVISIBLE);
                storyLine2_2Button.setVisibility(View.INVISIBLE);
                storyLine2_3_Button.setVisibility(View.INVISIBLE);
                storyLine2_4Button.setVisibility(View.VISIBLE);
            }
        });



        storyLine2_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                story2_1.setVisibility(View.INVISIBLE);
                story2_2.setVisibility(View.VISIBLE);

                storyLine2_1Button.setVisibility(View.INVISIBLE);
                storyLine2_2Button.setVisibility(View.VISIBLE);

                professor.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setVisibility(View.VISIBLE);
               maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_2.setVisibility(View.INVISIBLE);
                story2_3_.setVisibility(View.VISIBLE);

                storyLine2_2Button.setVisibility(View.INVISIBLE);
                storyLine2_3_Button.setVisibility(View.VISIBLE);


                name_professor.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setVisibility(View.INVISIBLE);
                maincharacter.clearColorFilter();

                skipButton.setVisibility(View.INVISIBLE);

                Intent intent =new Intent(getApplicationContext(),stage_eg_quiz2.class);
                startActivity(intent);

                story2_3_.setVisibility(View.INVISIBLE);
                story2_4.setVisibility(View.VISIBLE);

                storyLine2_3_Button.setVisibility(View.INVISIBLE);
                storyLine2_4Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
               name_professor.setVisibility(View.INVISIBLE);

            }
        });
        storyLine2_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hyunggu.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_4.setVisibility(View.INVISIBLE);
                story2_5.setVisibility(View.VISIBLE);

                storyLine2_4Button.setVisibility(View.INVISIBLE);
                storyLine2_5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyunggu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility(View.INVISIBLE);
                hyunggu.setVisibility(View.INVISIBLE);
                minsu.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story2_5.setVisibility(View.INVISIBLE);
                story2_6_.setVisibility(View.VISIBLE);

                storyLine2_5Button.setVisibility(View.INVISIBLE);
                storyLine2_6_Button.setVisibility(View.VISIBLE);

                name_hyunggu.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_6_Button.setOnClickListener(new View.OnClickListener() {
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
